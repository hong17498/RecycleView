package vn.edu.ntu.thuyhong.recycleview1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.thuyhong.controller.ICartController;
import vn.edu.ntu.thuyhong.model.Product;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<Product> ListProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }
    private void addViews()
    {
        rvListProduct = findViewById(R.id.rvListProduct);
        rvListProduct.setLayoutManager(new LinearLayoutManager(this));
        ICartController controller = (ICartController) getApplication();
        ListProducts = controller.getAllProduct();
        adapter = new ProductAdapter(ListProducts);
        rvListProduct.setAdapter(adapter);
    }
    private class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPrice, txtDesc;
        ImageView imvAddToCart;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imvAddToCart = this.itemView.findViewById(R.id.imvAddToCart);
        }
        public void bind(Product p)
        {
            txtName.setText(p.getName());
            txtDesc.setText(p.getDesc());
            txtPrice.setText(new Integer(p.getPrice()).toString());
        }
    }
    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{
        List<Product> listProducts;

        public ProductAdapter(List<Product> listProducts) {
            this.listProducts = listProducts;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent,false);

            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return listProducts.size();
        }
    }
}
