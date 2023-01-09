package com.mth.example.shoppe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mth.example.shoppe.ui.theme.ShopeeQrange

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Column {
            HeaderSection(modifier = Modifier.background(ShopeeQrange))
            FeatureSection(
                modifier = Modifier
                    .background(ShopeeQrange)
                    .fillMaxWidth()
                    .height(200.dp),
                listOf(
                    Feature("Khung Giờ Săn Sale", R.drawable.ic_feature1),
                    Feature("Gì Cũng Rẻ", R.drawable.ic_feature2),
                    Feature("Mã Giảm Giá", R.drawable.ic_feature3),
                    Feature("Miễn Phí Vận Chuyển", R.drawable.ic_feature4),
                    Feature("Bắt Tren - Giá Sốc", R.drawable.ic_feature5),
                    Feature("Hoàn Xu Từ 100k", R.drawable.ic_feature6),
                    Feature("Hàng Hiệu Giá Tốt", R.drawable.ic_feature7),
                    Feature("Nạp Thẻ & Dịch Vụ", R.drawable.ic_feature8),
                    Feature("Chia Kho Xu 30 Triệu", R.drawable.ic_feature9),
                    Feature("Hàng Quốc Tế", R.drawable.ic_feature10),
                )
            )
            FlashSaleSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                flashSaleProducts = listOf(
                    FlashSaleProduct(2990000, R.drawable.sale1, 8),
                    FlashSaleProduct(1059000, R.drawable.sale2, 42),
                    FlashSaleProduct(599000, R.drawable.sale3, 40),
                    FlashSaleProduct(279000, R.drawable.sale4, 52),
                    FlashSaleProduct(199000, R.drawable.sale5, 56),
                )
            )
            CategorySecton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                title = "DANH MỤC",
                features = listOf(
                    Feature("Thời Trang Nam", R.drawable.ic_category1),
                    Feature("Điện Thoại & Phụ Kiện", R.drawable.ic_category2),
                    Feature("Thiết Bị Điện Tử", R.drawable.ic_category3),
                    Feature("Máy Tính & Laptop", R.drawable.ic_category4),
                    Feature("Máy Ảnh", R.drawable.ic_category5),
                    Feature("Đồng Hồ", R.drawable.ic_category6),
                    Feature("Giày Dép Nam", R.drawable.ic_category7),
                    Feature("Thiết Bị Gia Dụng", R.drawable.ic_category8),
                    Feature("Thể Thao", R.drawable.ic_category9),
                    Feature("Ô Tô & Xe Máy", R.drawable.ic_category10),
                    Feature("Thời Trang Nũ", R.drawable.ic_category11),
                    Feature("Mẹ & Bé", R.drawable.ic_category12),
                    Feature("Nhà Cửa & Đời Sống", R.drawable.ic_category13),
                    Feature("Sắc Đẹp", R.drawable.ic_category14),
                    Feature("Sức Khoẻ", R.drawable.ic_category15),
                    Feature("Giày Dép Nữ", R.drawable.ic_category16),
                    Feature("Túi Ví Nữ", R.drawable.ic_category17),
                    Feature("Phụ Kiện Nữ", R.drawable.ic_category18),
                    Feature("Bách Hoá Online", R.drawable.ic_category19),
                    Feature("Nhà Sách Online", R.drawable.ic_category20),
                )
            )

            ProductSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                listProduct = listOf(
                    Product("Áo Polo Nam Cổ Bẻ Thun", R.drawable.img_product3, 69000),
                    Product("Áo thun nam loang màu thời trang", R.drawable.img_product4, 35000),
                    Product("Áo thun nam nữ CREWZ", R.drawable.img_product1, 59000),
                    Product("Túi nữ đeo chéo túi xách nữ đẹp", R.drawable.img_product2, 1000),
                )
            )
        }
    }
}

@Composable
fun MallScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Mall Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun LiveScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Live Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Notification Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun MyProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "MyProfile Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}


