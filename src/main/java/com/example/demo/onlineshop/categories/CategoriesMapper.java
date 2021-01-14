package com.example.demo.onlineshop.categories;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoriesMapper {

    @Select("select id, name, imageUri from categories")
    List<Categories> findAll();

    @Select("select id, name, imageUri from categories where name like #{name}")
    Categories findByName(String name);

    @Select("select id, name, imageUri from categories where id = #{id}")
    Categories findOne(Long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into categories (name, imageUri) values (#{name}, #{imageUri})")
    void create(Categories category);

    @Update("update categories set " +
            "name = #{name}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(Categories category);

    @Delete("delete from categories where id = #{id}")
    boolean deleteById(Long id);

}
