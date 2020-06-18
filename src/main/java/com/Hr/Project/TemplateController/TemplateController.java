package com.Hr.Project.TemplateController;

import com.Hr.Project.Model.LoginData;
import com.Hr.Project.RegularExpertion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
    @RequestMapping("/")
    public String index(Model model){
    //    LoginData loginData=new LoginData("mi@gmail","5ffhbrfdssd");
        LoginData loginData=new LoginData();
        model.addAttribute("loginData",loginData);
      //  model.addAttribute("email","milad@gmail");
       // model.addAttribute("password","milad@gmail6666");
        return "index";
    }
    @RequestMapping("/adminLogin")
    public String adminLogin(@ModelAttribute ("loginData") LoginData loginData){
              if(RegularExpertion.checkPassword(loginData.getPassword())
                      &RegularExpertion.checkEmail(loginData.getEmail())){

                  System.out.println(loginData.getEmail()+loginData.getPassword());
                  return "adminLogin";
              }else{
                  return  "index";
              }
    }
    @RequestMapping("/librarianLogin")
    public String librarianLogin(@ModelAttribute("loginData")LoginData loginData){
        if(RegularExpertion.checkPassword(loginData.getPassword())
                &RegularExpertion.checkEmail(loginData.getEmail())){

            System.out.println(loginData.getEmail()+loginData.getPassword());
            return "librarianLogin";
        }else{
            return  "index";
        }
    }
}
