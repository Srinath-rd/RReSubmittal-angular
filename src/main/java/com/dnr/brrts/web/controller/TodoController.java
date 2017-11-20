package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.Todo;
import com.dnr.brrts.web.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class TodoController {

    @Autowired
    TodoService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        logger.debug("..............Inside initBinder method..................");
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        logger.debug("..............Inside showTodos method..................");
        System.out.println("This is a message");
        logger.info("This is an imp message");
        logger.warn("This is a warning");
        logger.error("This is an error");
        logger.debug("exception");
        String name = getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value = "/wizardform1", method = RequestMethod.GET)
    public String showTodos1(ModelMap model) {
        return "list-todos1";
    }

    @RequestMapping(value = "/wizardform2", method = RequestMethod.GET)
    public String showTodos2(ModelMap model) {
        return "list-todos2";
    }


    @RequestMapping(value = "/wizardform3", method = RequestMethod.GET)
    public String showTodos3(ModelMap model) {
        return "list-todos3";
    }

    @RequestMapping(value = "/wizardform4", method = RequestMethod.GET)
    public String showTodos4(ModelMap model) {
        return "list-todos4";
    }

    @RequestMapping(value = "/wizardform5", method = RequestMethod.GET)
    public String showTodos5(ModelMap model) {
        return "list-todos5";
    }

    @RequestMapping(value = "/list-todos-alt", method = RequestMethod.GET)
    public String showTodosAlt(ModelMap model) {
        logger.info("..............Inside showTodosAlt method..................");
        String name = getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos-alt";
    }

    @RequestMapping(value = "/list-todos-alt3", method = RequestMethod.GET)
    public String showTodosAlt3(ModelMap model) {
        logger.info("..............Inside showTodosAlt3 method..................");
        String name = getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos-alt3";
    }

    private String getLoggedInUserName(ModelMap model) {
        logger.info("..............Inside getLoggedInUserName method..................");
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        logger.info("..............Inside showAddTodoPage method..................");
        model.addAttribute("todo", new Todo(0, getLoggedInUserName(model),
                "Default Desc", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        logger.info("..............Inside deleteTodo method..................");
        if (id == 1)
            throw new RuntimeException("Something went wrong");

        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        logger.info("..............Inside showUpdateTodoPage method..................");
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo,
                             BindingResult result) {
        logger.info("..............Inside updateTodo method..................");
        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUser(getLoggedInUserName(model));

        service.updateTodo(todo);

        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        logger.info("..............Inside addTodo method..................");
        if (result.hasErrors()) {
            return "todo";
        }

        service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(),
                false);
        return "redirect:/list-todos";
    }



}
