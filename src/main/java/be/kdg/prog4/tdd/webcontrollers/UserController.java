package be.kdg.prog4.tdd.webcontrollers;

import be.kdg.prog4.tdd.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Moussa on 4/12/2015.
 */
@Controller
public class UserController {

    private final FavoriteService favoriteService;

    @Autowired
    public UserController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
       // favoriteService.addUser("root","rootpasswd","root","Moussa");
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpSession session, @RequestParam String username, @RequestParam String password, ModelAndView modelAndView) {


            if(username.equals("root") && password.equals("rootpasswd")){
                modelAndView.setViewName("/rootpage");

                return modelAndView;
            }else if(favoriteService.checkLogin(username,password)){
                modelAndView.setViewName("/normaluser");

                session.setAttribute("username",username);
                session.setAttribute("password",password);
                modelAndView.addObject("favorites",favoriteService.getFavorites(username, password));
                return modelAndView;
            }
                modelAndView.setViewName("index");
                modelAndView.addObject("error", "Wrong username or password");
                return modelAndView;



    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String newusername,@RequestParam String newpassword, ModelAndView modelAndView) {

        favoriteService.addUser("root","rootpasswd",newusername,newpassword);

        modelAndView.setViewName("index");

        return modelAndView;

    }

    @RequestMapping(value = "/addfavorite.do", method = RequestMethod.POST)
    public ModelAndView addfavorite(HttpSession session, @RequestParam String favorite, ModelAndView modelAndView) {

        String username= (String) session.getAttribute("username");
        String password= (String) session.getAttribute("password");

        favoriteService.addFavorite(username,password,favorite);
        modelAndView.addObject("favorites",favoriteService.getFavorites(username, password));
        modelAndView.setViewName("/normaluser");

        return modelAndView;

    }





}
