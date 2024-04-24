package by.itclass.model.services;

import by.itclass.model.entities.OrderItem;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static by.itclass.constants.JSPConstant.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService cartService;

    public static CartService getInstance() {
        return Objects.isNull(cartService) ? new CartService() : cartService;
    }

    public List<OrderItem> processCart(HttpSession session, String cartAction, OrderItem item) {
        var orderItems = session.getAttribute(ORDER_ITEMS_ATTR);
        List<OrderItem> items = Objects.nonNull(orderItems) ? (List<OrderItem>) orderItems : new ArrayList<>();
        switch (cartAction) {
            case "add" -> items.add(item);
            case "remove" -> items.remove(item);
            case "increase" -> items.forEach(it -> changePurchase(it, item, true));
            case "decrease" -> items.forEach(it -> changePurchase(it, item, false));
        }
        return items;
    }

    private void changePurchase(OrderItem sourceItem, OrderItem changedItem, boolean isPlus) {
        if (sourceItem.equals(changedItem)) {
            var quantity = sourceItem.getQuantity();
            sourceItem.setQuantity(isPlus ? quantity + 1 : quantity - 1);
        }
    }
}
