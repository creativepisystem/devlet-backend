package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.utils.BaseIntegrationTest;

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
