package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registNewMenu(MenuDTO menu) {
        menuMapper.registNewMenu(menu);
    }

    @Transactional  // commit(), rollback() 등의 일종의 AOP기능을 담당하는 어노테이션
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }

    @Transactional
    public void deleteMenu(int code) {
        menuMapper.deleteMenu(code);
    }
}
