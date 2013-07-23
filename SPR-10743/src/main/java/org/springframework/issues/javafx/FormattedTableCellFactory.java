package org.springframework.issues.javafx;

import java.text.Format;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class FormattedTableCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>>{
	private Pos aligment;
	private Format format;
		
	public FormattedTableCellFactory(Pos aligment) {
		super();
		this.aligment = aligment;
	}

	public FormattedTableCellFactory(Pos aligment, Format format) {
		super();
		this.aligment = aligment;
		this.format = format;
	}
	
	public Pos getAligment() {
		return aligment;
	}

	public void setAligment(Pos aligment) {
		this.aligment = aligment;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public TableCell<S, T> call(TableColumn<S, T> param) {
		TableCell<S, T> cell = new TableCell<S, T>(){
            @Override
			protected void updateItem(T item, boolean empty) {
            	if (item == getItem()) {
                    return;
                }
                super.updateItem((T) item, empty);
                if (item == null) {
                    super.setText(null);
                    super.setGraphic(null);
                } else if (format != null) {
                    super.setText(format.format(item));
                } else if (item instanceof Node) {
                    super.setText(null);
                    super.setGraphic((Node) item);
                } else {
                    super.setText(item.toString());
                    super.setGraphic(null);
                }
			}

			private String getString() {
                return getItem() == null ? "" : getItem().toString();
            }
		};
		cell.setAlignment(aligment);
		
		return cell;
	}
	
}
