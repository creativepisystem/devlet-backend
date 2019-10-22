package br.com.creative.devlet.web.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class, secure = false)
public class UserControllerTests {

//    @MockBean
//    UserService userService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    User existingUser, newUser, updateUser;
//
//    @Before
//    public void setUp() {
//        newUser = TestHelper.buildUserWithId();
//        existingUser = TestHelper.buildUserWithId();
//        updateUser = TestHelper.buildUserWithId();
//    }
//
//    @Test
//    public void should_get_all_users() throws Exception {
//        given(userService.getAllUsers()).willReturn(Arrays.asList(existingUser, updateUser));
//
//        this.mockMvc
//                .perform(get("/api/users"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));
//    }
//
//    @Test
//    public void should_get_user_by_id() throws Exception {
//        given(userService.getUserById(existingUser.getId())).willReturn(Optional.of(existingUser));
//
//        this.mockMvc
//                .perform(get("/api/users/"+existingUser.getId()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(existingUser.getId())))
//                .andExpect(jsonPath("$.name", is(existingUser.getName())))
//                .andExpect(jsonPath("$.email", is(existingUser.getEmail())));
//    }
//
//    @Test
//    public void should_create_user() throws Exception {
//        given(userService.createUser(newUser)).willReturn(newUser);
//
//        this.mockMvc
//                .perform(post("/api/users/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(newUser))
//                )
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", notNullValue()))
//                .andExpect(jsonPath("$.name", is(newUser.getName())))
//                .andExpect(jsonPath("$.email", is(newUser.getEmail())));
//    }
//
//    @Test
//    public void should_update_user() throws Exception {
//        given(userService.updateUser(existingUser)).willReturn(existingUser);
//
//        this.mockMvc
//                .perform(put("/api/users/"+existingUser.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(existingUser))
//                )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(existingUser.getId())))
//                .andExpect(jsonPath("$.name", is(existingUser.getName())))
//                .andExpect(jsonPath("$.email", is( existingUser.getEmail())));
//    }
//
//    @Test
//    public void should_delete_user() throws Exception {
//        doNothing().when(userService).deleteUser(existingUser.getId());
//
//        this.mockMvc
//                .perform(delete("/api/users/"+existingUser.getId()))
//                .andExpect(status().isOk());
//    }

}
