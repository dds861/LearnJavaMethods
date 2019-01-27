package com.dd.learnjavamethods.Model;

import com.dd.learnjavamethods.View.Product;

import java.util.List;

public interface IModel {


    List<Product> getListFromDatabase(String tableName);
}
