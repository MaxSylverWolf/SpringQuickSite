package sylverwolf.mvcspring1;

import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by szkolenia on 2017-07-07.
 */
public class AppStarter extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected String getServletName() {
        return "AppStarter";
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        FilterRegistration.Dynamic openEntityManagerFilter = servletContext.addFilter("openEntityManagerFilter",
            new OpenEntityManagerInViewFilter());
        openEntityManagerFilter.setInitParameter("entityManagerFactoryBeanName", "lcemf");
        openEntityManagerFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
