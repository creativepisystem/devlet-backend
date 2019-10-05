package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.model.ChangePasswordModel;
import br.com.creative.devlet.utils.BaseIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthenticationControllerIT extends BaseIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @Before
//    public void setUp() {
//        setupTestData();
//    }
//
//    @After
//    public void tearDown() {
//        cleanupTestData();
//    }
//
//    @Test
//    @WithMockUser("admin")
//    public void shouldReturnAuthenticatedUser() throws Exception {
//        this.mockMvc
//                .perform(get("/api/me"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Admin")));
//    }
//
//    @Test
//    @WithMockUser("admin")
//    public void shouldChangePassword() throws Exception {
//        ChangePasswordModel model = new ChangePasswordModel();
//        model.setOldPassword("admin");
//        model.setNewPassword("12345678");
//        model.setConfirmNewPassword("12345678");
//        this.mockMvc.perform(post("/api/change-password")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(model)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.message", contains("Password changed successfully")));
//    }
}
