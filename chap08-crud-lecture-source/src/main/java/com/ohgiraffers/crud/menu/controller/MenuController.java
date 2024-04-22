package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        for( MenuDTO menu : menuList ) {
            System.out.println("menus = " + menu);
        }

        model.addAttribute("menuList",menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){

        menuService.findAllCategory().forEach(System.out::println);
        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(MenuDTO menu, RedirectAttributes rttr){
        menuService.registNewMenu(menu);

        rttr.addFlashAttribute("successMessage","신규 메뉴 등록 성공!");

        return "redirect:/menu/list";
    }

    @GetMapping("/update")
    public void updatePage() {}

    @PostMapping("/update")
    public String updateMenu(MenuDTO menu, RedirectAttributes rttr) {
        menuService.updateMenu(menu);

        rttr.addFlashAttribute("successMessage","메뉴 수정 성공!");
        return "redirect:/menu/list";
    }

    @GetMapping("/delete")
    public void deletePage(){}

    @PostMapping("/delete")
    public String deleteMenu(int code, RedirectAttributes rttr) {
        menuService.deleteMenu(code);
        rttr.addFlashAttribute("successMessage", code + "번 메뉴 삭제 성공!");
        return "redirect:/menu/list";
    }
}