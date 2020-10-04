package io.github.brenovit.swipe.auth.config;

public class SecurityCredentialsConfig {


//    private UserDetailsService userDetailsService;
//
//
//    private JwtConfig jwtConfig;
//
//
//    private JwtTokenProvider tokenProvider;
//
//
//    private UserService userService;
//
//
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                //.addFilterBefore(new JwtTokenAuthenticationFilter(jwtConfig, tokenProvider, userService), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/signin").permitAll()
//                .antMatchers(HttpMethod.POST, "/users").anonymous()
//                .antMatchers(HttpMethod.GET, "/actuator", "/actuator/health", "/actuator/info").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Configure DB authentication provider for user accounts
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean(BeanIds.AUTHENTICATION_MANAGER)
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
}
