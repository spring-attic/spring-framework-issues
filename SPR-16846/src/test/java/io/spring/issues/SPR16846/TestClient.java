package io.spring.issues.SPR16846;

import org.springframework.web.reactive.function.client.WebClient;

public class TestClient {

	public static void main(String[] args) {

		WebClient.create().post().uri("http://localhost:8080/test")
				.syncBody("{\"object\":\"page\",\"entry\":[{\"id\":\"161041321255998\",\"time\":1526701141870,\"messaging\":[{\"sender\":{\"id\":\"1675373035849843\"},\"recipient\":{\"id\":\"161041321255998\"},\"timestamp\":1526701140949,\"message\":{\"mid\":\"mid.$cAACSd3rlhiVpp7_z1VjdnqpzbMei\",\"seq\":536509,\"attachments\":[{\"title\":\"Cupcake Corner Bakery\",\"url\":\"https:\\/\\/l.facebook.com\\/l.php?u=https\\u00253A\\u00252F\\u00252Fwww.bing.com\\u00252Fmaps\\u00252Fdefault.aspx\\u00253Fv\\u00253D2\\u002526pc\\u00253DFACEBK\\u002526mid\\u00253D8100\\u002526where1\\u00253DPiotra\\u00252BMicha\\u002525C5\\u00252582owskiego\\u00252B14\\u0025252C\\u00252B31-326\\u00252B\\u002525D0\\u0025259A\\u002525D1\\u00252580\\u002525D0\\u002525B0\\u002525D0\\u002525BA\\u002525D0\\u002525BE\\u002525D0\\u002525B2\\u002526FORM\\u00253DFBKPL1\\u002526mkt\\u00253Den-US&h=ATM-Sf5N5LphePMuIUa6vwD-qLpC2Lp-hPDo_tvQRa5xlzMy6mLjPP9pdGqmsHmyA4PVrDc_0-X5-8cgAdcUYg78AN3g2qKQBOa95fE0451S_iRPaXR4g67VtMZsUc0&s=1\",\"type\":\"location\",\"payload\":{\"coordinates\":{\"lat\":50.06582,\"long\":19.92785}}}]}}]}]}")
				.retrieve()
				.bodyToMono(Void.class)
				.block();
	}

}
