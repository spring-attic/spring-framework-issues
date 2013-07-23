package org.springframework.issues.javafx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.beans.OrderService;
import org.springframework.issues.javafx.FormattedTableCellFactory;
import org.springframework.issues.javafx.OrderTableRow;
import org.springframework.issues.javafx.TestApplication;
import org.springframework.issues.pojos.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;


@Controller
public class SearchController{
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Button cancel;
	@FXML
	private Button search;
	@FXML
	private TextField productName;
	@FXML
	private TextField maxPrice;
	@FXML
	private TextField minPrice;
	@FXML
	private TableColumn<OrderTableRow, Integer> customerId;
	@FXML
	private TableColumn<OrderTableRow, Boolean> delivered;
	@FXML
	private TableColumn<OrderTableRow, Integer> deliveryDays;
	@FXML
	private TableColumn<OrderTableRow, Integer> orderId;
	@FXML
	private TableColumn<OrderTableRow, Integer> productsCount;
	@FXML
	private TableColumn<OrderTableRow, Integer> totalOrderPrice;
	@FXML
	private TableView<OrderTableRow> table;
	@Autowired
	OrderService orderService;
	private Stage dialogStage;

	@FXML
	public void initialize() {
		orderId.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Integer>("orderId"));
		orderId.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Integer>(Pos.CENTER_RIGHT));
		customerId.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Integer>("customerId"));
		customerId.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Integer>(Pos.CENTER_RIGHT));
		productsCount.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Integer>("products"));
		productsCount.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Integer>(Pos.CENTER_RIGHT));
		delivered.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Boolean>("delivered"));
		delivered.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Boolean>(Pos.CENTER));
		deliveryDays.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Integer>("deliveryDays"));
		deliveryDays.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Integer>(Pos.CENTER_RIGHT));
		totalOrderPrice.setCellValueFactory(new PropertyValueFactory<OrderTableRow, Integer>("total"));
		totalOrderPrice.setCellFactory(new FormattedTableCellFactory<OrderTableRow, Integer>(Pos.CENTER_RIGHT));
		
		List<Order> orders = orderService.findAllOrders();
		ObservableList<OrderTableRow> orderRows = FXCollections.observableArrayList();
		for(Order order : orders) {
			orderRows.add(new OrderTableRow(order));
		}
		table.setItems(orderRows);
	}
	
	public void showView(Stage primaryStage) {
		if(dialogStage==null) {
			Parent root = (Parent) TestApplication.loader.load("/search.fxml");
			Scene scene = new Scene(root, 768, 480);
			dialogStage = new Stage();
			dialogStage.initOwner(primaryStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.setScene(scene);
			dialogStage.setTitle("JavaFX Spring Demo");
		}
		dialogStage.show();
	}

	public void search() {
		try {
			secureSearch();
			System.out.println("searching....");
		}catch(AccessDeniedException ex) {
			System.out.println("you don't has permission to make search");
		}
	}
	
	@Secured("ROLE_MANAGER")
	public void secureSearch() {
		
	}

	public void clear() {
		table.setItems(null);
		productName.setText("");
		minPrice.setText("");
		maxPrice.setText("");
	}
}
