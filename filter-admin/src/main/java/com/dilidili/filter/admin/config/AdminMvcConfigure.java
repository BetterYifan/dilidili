public class AdminMvcConfigure implements WebMvcConfigure {
  
  @Value("${application.ignoreUrls}")
  private List<String> ignoreUrls;
  
  @Autowired
  private ValidateInterceptor validateInterceptor;
  
  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(validateInterceptor).addPathPatterns("/**").excludePathPatterns(ignoreUrls);
    }

}
