package com.mohammad.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.mohammad.springboot.entity.Family;
import com.mohammad.springboot.service.FamilyService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import utils.LoggerUtil;

@SpringBootTest
@AutoConfigureMockMvc
class FamilyControllerIntegrationIT {
	private static final Logger log = LoggerUtil.getLogger(FamilyControllerIntegrationIT.class);

    @Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FamilyService familyService;

	@Test
	void shouldDisplayFamilyList() throws Exception {
		mockMvc.perform(get("/families/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("families/list-families"));
	}
	@Test
	void shouldDisplayAddFamilyForm() throws Exception {
		mockMvc.perform(get("/families/showFormForAdd")).andExpect(status().isOk()).andExpect(view().name("families/family-form"))
				.andExpect(model().attributeExists("family"));
	}
	@Test
	void shouldDisplayShowFormUpdate() throws Exception {
		Family family = new Family();
		family.setId(1);
		family.setFirstName("John");
		family.setLastName("Doe");
		when(familyService.findById(1)).thenReturn(family);
		mockMvc.perform(get("/families/showFormForUpdate").param("familyId", "1")).andExpect(status().is2xxSuccessful()).andExpect(view().name("families/family-form"))
				.andExpect(model().attributeExists("family"));
		verify(familyService).findById(1);
	}
	@Test
	void shouldSaveFamily() throws Exception {
		mockMvc.perform(post("/families/save").param("id", "1").param("firstName", "John").param("lastName", "Doe"))
		.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/families/list"));

		verify(familyService).save(any(Family.class));
	}
	@Test
	void shouldDeleteFamily() throws Exception {
		doNothing().when(familyService).deletedById(1);

		mockMvc.perform(get("/families/delete").param("familyId", "1"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/families/list"));
		verify(familyService).deletedById(1);
	}
}
