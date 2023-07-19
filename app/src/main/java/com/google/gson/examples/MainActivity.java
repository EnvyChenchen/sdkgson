package com.google.gson.examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.R;
import com.google.gson.examples.model.Cart;
import com.google.gson.examples.model.LineItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:
 * @desc:
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv_content);
        Gson gson = new Gson();
        Cart cart = buildCart();
        StringBuilder sb = new StringBuilder();
        sb.append("Gson.toJson() example: \n");
        sb.append("  Cart Object: ").append(cart).append("\n");
        sb.append("  Cart JSON: ").append(gson.toJson(cart)).append("\n");
        sb.append("\n\nGson.fromJson() example: \n");
        String json = "{buyer:'Happy Camper',creditCard:'4111-1111-1111-1111',"
                + "lineItems:[{name:'nails',priceInMicros:100000,quantity:100,currencyCode:'USD'}]}";
        sb.append("Cart JSON: ").append(json).append("\n");
        sb.append("Cart Object: ").append(gson.fromJson(json, Cart.class)).append("\n");
        tv.setText(sb.toString());
        tv.invalidate();
    }

    private Cart buildCart() {
        List<LineItem> lineItems = new ArrayList<>();
        lineItems.add(new LineItem("hammer", 1, 12000000, "USD"));
        return new Cart(lineItems, "Happy Buyer", "4111-1111-1111-1111");
    }
}
