package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.service.domain.EventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/add-event")
public class AdminAddEvent extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    UserAuthenticationService userAuthenticationService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "admin-add-event.ftlh");
        Map<String, Object> model = new HashMap<>();
        final String googleId = (String) req.getSession().getAttribute("googleId");

        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
        } else {
            model.put("logged", "no");
            model.put("loginUrl", userAuthenticationService.buildLoginUrl());
        }
        try {
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");
        String nameParam = req.getParameter("name");
        String loginParam = req.getParameter("login");
        String ageParam = req.getParameter("age");
/*
        User user = new User();
        user.setId(Long.valueOf(idParam));
        user.setName(nameParam);
        user.setLogin(loginParam);
        user.setAge(Integer.valueOf(ageParam));

        Part image = req.getPart("image");
        String imageUrl = "";
        try {
            imageUrl = "/images/" + fileUploadProcessor
                    .uploadImageFile(image).getName();
        } catch (UserImageNotFound userImageNotFound) {
            logger.warning(userImageNotFound.getMessage());
        }

        user.setImageUrl(imageUrl);

        userService.saveUser(user);*/

        resp.getWriter().println("User has been added.");
    }
}
