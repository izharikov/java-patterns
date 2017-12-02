package com.patterns;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ihar Zharykau
 */
public class Mediator {
    public static void main(String... args) {
        SeoServiceMediator mediator = new SeoServiceMediator();
        mediator.setSeoOption(SeoOption.AliasOff);
        mediator.printCurrentSeoService();
        mediator.setSeoOption(SeoOption.AliasOn);
        mediator.printCurrentSeoService();
    }
}

enum SeoOption {
    AliasOn, AliasOff
}

interface SeoService<T> {
    void setOption(SeoOption option);

    String generate(T obj);
}

class SeoServiceMediator {
    private ProductSeoService productSeoService;
    private CategorySeoService categorySeoService;

    public SeoServiceMediator() {
        productSeoService = new ProductSeoService();
        categorySeoService = new CategorySeoService();
    }

    void setSeoOption(SeoOption seoOption) {
        productSeoService.setOption(seoOption);
        categorySeoService.setOption(seoOption);
    }

    public ProductSeoService getProductSeoService() {
        return productSeoService;
    }

    public CategorySeoService getCategorySeoService() {
        return categorySeoService;
    }

    public void printCurrentSeoService() {
        System.out.println("productSeoService " + productSeoService.currentOption);
        System.out.println("categorySeoService " + categorySeoService.currentOption);
    }
}

abstract class BaseSeoService<T> implements SeoService<T> {
    protected SeoOption currentOption;

    @Override
    public void setOption(SeoOption option) {
        currentOption = option;
    }
}

class ProductSeoService extends BaseSeoService<Product> {
    @Override
    public String generate(Product obj) {
        String url = "";
        switch (currentOption) {
            case AliasOff:
                List<String> parentCategoriesName = obj.getParentCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toList());
                url = String.join("/",
                        parentCategoriesName) + "/" + obj.getName();
                break;
            case AliasOn:
                url = obj.getName();
                break;
        }
        return url;
    }
}

class CategorySeoService extends BaseSeoService<Category> {
    @Override
    public String generate(Category obj) {
        String url = "";
        switch (currentOption) {
            case AliasOff:
                List<String> parentCategoriesName = obj.getParentCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toList());
                url = String.join("/",
                        parentCategoriesName) + "/" + obj.getName();
                break;
            case AliasOn:
                url = obj.getName();
                break;
        }
        return url;
    }
}