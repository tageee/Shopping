package com.shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tage on 1/25/16.
 */
public class Category {
    private int id;
    private int pid;
    private String name;
    private String descr;
    private boolean leaf;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void addChild(Category c) {
        addChildCategory(c.getName(), c.getDescr(), id);
    }

    public static void add(Category c) {
        CategoryDAO.save(c);
    }

    public static void addTopCategory(String name, String descr) {
        Category c = new Category();
        c.setId(-1);
        c.setName(name);
        c.setDescr(descr);
        c.setPid(0);
        c.setLeaf(true);
        c.setGrade(1);
        add(c);
    }

    public static List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        CategoryDAO.getCategories(list, 0);
        return list;

    }

    public static void addChildCategory(String name, String descr, int pid) {
        Category c = new Category();
        c.setId(-1);
        c.setName(name);
        c.setDescr(descr);
        c.setPid(pid);
        c.setGrade(CategoryDAO.getGrade(pid) + 1);

        CategoryDAO.addChild(c);
    }

    public static Category loadById(int id) {
        return CategoryDAO.loadById(id);
    }
}
