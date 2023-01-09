package com.mth.example.shoppe

import android.widget.ScrollView
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mth.example.shoppe.ui.theme.OrangeYellow1
import com.mth.example.shoppe.ui.theme.SaleYellow
import com.mth.example.shoppe.ui.theme.ShopeeQrange
import java.text.DecimalFormat
import java.text.SimpleDateFormat

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.advertisement),
            contentDescription = "advert",
            contentScale = ContentScale.None,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            SearchBar()
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = "cart",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_message2),
                    contentDescription = "cart",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        PayBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(7.dp))
                .border(0.7.dp, Color.Gray)
        )
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .padding(7.dp)
            .background(Color.White)
            .fillMaxWidth(0.7f)
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Dây Đồng Hồ Thông Minh",
                color = OrangeYellow1,
                fontSize = 14.sp
            )

        }
        Icon(
            painter = painterResource(id = R.drawable.ic_camera),
            contentDescription = "camera",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun PayBar(
    money: Int = 0,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .background(Color.White)
            .padding(10.dp)

    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = "scan",
                modifier = Modifier
                    .padding(20.dp)
                    .size(28.dp)
                    .align(Alignment.CenterVertically)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                    Text(
                        text = "Ví ShopeePay",
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Voucher giảm đến 40.000đ",
                        lineHeight = 15.sp,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(modifier = Modifier.fillMaxWidth(1f)) {
                    Text(
                        text = "$money Xu",
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Đổi xu lấy mã giảm giá",
                        lineHeight = 15.sp,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(
    modifier: Modifier,
    listFeature: List<Feature>,
    sizeIcon: Int = 40,
    sizeText: Int = 10,
    colorText: Color = Color.White,
    rowNumber: Int = 2
) {
    LazyHorizontalGrid(
        modifier = modifier
            .padding(10.dp),
        rows = GridCells.Fixed(rowNumber),
        contentPadding = PaddingValues(
            start = 3.dp,
            end = 3.dp,
            bottom = 12.dp
        ),
        content = {
            items(listFeature.size) {
                FeatureItem(listFeature[it], sizeIcon, sizeText, colorText)
            }
        }
    )
}

@Composable
private fun FeatureItem(
    feature: Feature,
    sizeIcon: Int,
    sizeText: Int,
    colorText: Color,
) {
    Column {
        Image(
            modifier = Modifier
                .size(sizeIcon.dp)
                .clip(RoundedCornerShape(5.dp)),
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title
        )
        Text(
            text = feature.title,
            fontSize = sizeText.sp,
            fontWeight = FontWeight.Normal,
            color = colorText,
            modifier = Modifier.fillMaxWidth(0.5f)
        )
    }
}

@Composable
fun FlashSaleSection(
    modifier: Modifier = Modifier,
    flashSaleProducts: List<FlashSaleProduct>
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.flash_sale),
            contentDescription = "flashsale",
        )
        LazyRow(
            contentPadding = PaddingValues(
                start = 5.dp,
                end = 5.dp
            )
        ) {
            items(flashSaleProducts.size) {
                FlashSaleProductItem(flashSaleProduct = flashSaleProducts[it])
            }
        }
    }
}

@Composable
fun FlashSaleProductItem(
    flashSaleProduct: FlashSaleProduct
) {
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints {
            Image(
                painter = painterResource(id = flashSaleProduct.imageId),
                contentDescription = "flashsaleproduct",
                modifier = Modifier.size(140.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.backgroundsale),
                contentDescription = "backgroundsale",
                modifier = Modifier.size(140.dp)
            )
            Box(
                modifier = Modifier
                    .size(37.dp)
                    .background(SaleYellow)
                    .align(Alignment.TopEnd)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${flashSaleProduct.saleRate} %",
                        color = ShopeeQrange,
                        fontSize = 10.sp
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Giảm",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }
        val dcf = DecimalFormat("###,###")
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "đ${dcf.format(flashSaleProduct.price)}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = ShopeeQrange
        )
    }
}

@Composable
fun CategorySecton(
    modifier: Modifier = Modifier,
    title: String,
    features: List<Feature>
) {
    Column {
        TitleSection(title = title)
        FeatureSection(
            modifier = modifier,
            listFeature = features,
            sizeIcon = 80,
            sizeText = 10,
            colorText = Color.Black
        )
    }
}

@Composable
fun TitleSection(
    modifier: Modifier = Modifier,
    title: String,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = ShopeeQrange,
    size: Int = 15
) {
    Text(
        modifier = modifier.padding(10.dp),
        text = title,
        fontWeight = fontWeight,
        color = color,
        fontSize = size.sp
    )
}

@Composable
fun ProductSection(
    modifier: Modifier = Modifier,
    listProduct: List<Product>
) {
    Column {
        TitleSection(title = "GỢI Ý HÔM NAY")
    }
    LazyVerticalGrid(
        modifier = modifier.padding(10.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 3.dp,
            end = 3.dp,
            bottom = 10.dp
        ),
        content = {
            items(listProduct.size) {
                ProductItem(product = listProduct[it])
            }
        })
}

@Composable
fun ProductItem(
    product: Product
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .size(250.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = product.imageId),
            contentDescription = "imageproduct"
        )
        Text(
            modifier = Modifier.padding(3.dp),
            text = product.title,
            fontSize = 12.sp,
            color = Color.Black
        )
        val dcf = DecimalFormat("###,###")
        Text(
            modifier = Modifier.padding(3.dp),
            text = "${dcf.format(product.priceProduct)}",
            fontSize = 14.sp,
            color = ShopeeQrange
        )
    }
}

@Composable
fun BottomMenu(
    modifier: Modifier = Modifier,
    items: List<BottomMenuContent>,
    activeHighlightColor: Color = ShopeeQrange,
    initSelectedItemIndex: Int = 0
) {
//    var selectedItemIndex by remember {
//        mutableStateOf(initSelectedItemIndex)
//    }
//    Row(
//        horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .fillMaxWidth()
//            .background(Color.White)
//            .padding(15.dp)
//    ) {
//        items.forEachIndexed { index, item ->
//
//        }
//    }

    val navController = rememberNavController()
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean= false,
    activeHighlightColor: Color = ShopeeQrange,
    onItemClick: () -> Unit
) {
    Column {

    }
}

@Preview(showSystemUi = true)
@Composable
fun ScreenPreview() {
    HomeScreen()
//    ProductItem(product = Product("Áo Polo Nam Cổ Bẻ Thun", R.drawable.img_product1, 69000))
//    FlashSaleProductItem(flashSaleProduct = FlashSaleProduct(100, R.drawable.sale1, 8))
}

