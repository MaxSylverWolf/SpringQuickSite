package sylverwolf.mvcspring1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by szkolenia on 2017-07-07.
 */
@Controller
@RequestMapping(value = {"/"})
public class MainController {

    //@ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String Hello()
    {
        return "HelloWorld";
    }
}
