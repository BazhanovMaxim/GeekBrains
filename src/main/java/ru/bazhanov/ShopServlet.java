package ru.bazhanov;

import entity.Product;
import lombok.extern.log4j.Log4j;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private StringBuilder builder;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Log: GET");
        List<Product> products = getProductList();

        resp.setCharacterEncoding("UTF-8");

        builder.append("<html><body><meta charset=UTF-8></meta>");
        builder.append("<h3>Список продуктов в корзине</h3>");
        for (Product product : products) {
            builder.append(product.getId())
                    .append(") ")
                    .append(product.getTitle())
                    .append(" ")
                    .append(product.getPrice())
                    .append("p.")
                    .append("<br>");
        }

        builder.append("</body></html>");

        resp.getWriter().printf(builder.toString());
        builder.setLength(0);
    }


    @Override
    public void destroy() {
        log.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        log.debug("Init");
        builder = new StringBuilder();
    }

    /**
     * Добавление продуктов в карзину
     *
     * @return список продуктов
     */
    private List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Помидоры", 120));
        products.add(new Product(2, "Огурцы", 70));
        products.add(new Product(3, "Баклажаны", 90));
        products.add(new Product(4, "Морковь", 400));
        products.add(new Product(5, "Вода", 100));
        products.add(new Product(6, "Мясо", 900));
        products.add(new Product(7, "Орехи", 250));
        products.add(new Product(8, "Мороженое", 450));
        products.add(new Product(9, "Кофе", 500));
        return products;
    }

}
