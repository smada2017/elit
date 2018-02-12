import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.util.ArrayList;

/**
 * The Class ChessGui.
 * @version 1.1
 * @author Sai Mada
 */
public class ChessGui extends Application {

    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override public void start(Stage stage) {
        ChessDb chessDb = new ChessDb();
        ObservableList<ChessGame> chessGame =
            FXCollections.observableArrayList(chessDb.getGames());
        TableView<ChessGame> table = createTable(chessGame);

        Button viewButton = new Button("View Message");
        viewButton.setOnAction(e -> {
                ChessGame msg = table.getSelectionModel().getSelectedItem();
                viewDialog(msg);
            });
        viewButton.disableProperty()
            .bind(Bindings.isNull(
                table.getSelectionModel().selectedItemProperty()));

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> Platform.exit());

        TextField doraTheExplorer = new TextField();

        doraTheExplorer.textProperty().addListener(
            (mapBackpack, oldItems, newItems) -> {
                String dora = newItems.toLowerCase();
                ArrayList<ChessGame> exploringTime = new ArrayList<>();
                for (ChessGame game : chessDb.getGames()) {
                    if (game.getEvent().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    } else if (game.getBlack().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    } else if (game.getResult().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    } else if (game.getSite().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    } else if (game.getDate().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    } else if (game.getWhite().toLowerCase().contains(dora)) {
                        exploringTime.add(game);
                    }

                }
                chessGame.clear();
                chessGame.addAll(exploringTime);
            });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(
            viewButton, dismissButton, doraTheExplorer);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, buttonBox);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Chess GUI");
        stage.show();
    }

    /**
     * Creates the table.
     *
     * @param chessGame the chess game
     * @return the table view
     */
    private
        TableView<ChessGame>
        createTable(ObservableList<ChessGame> chessGame) {
        TableView<ChessGame> table = new TableView<ChessGame>();
        table.setItems(chessGame);

        TableColumn<ChessGame, String> eventCol =
            new TableColumn<ChessGame, String>("Event");
        eventCol.setCellValueFactory(new PropertyValueFactory("event"));

        TableColumn<ChessGame, String> siteCol =
            new TableColumn<ChessGame, String>("Site");
        siteCol.setCellValueFactory(new PropertyValueFactory("site"));

        TableColumn<ChessGame, String> dateCol =
            new TableColumn<ChessGame, String>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));

        TableColumn<ChessGame, String> whiteCol =
            new TableColumn<ChessGame, String>("White");
        whiteCol.setCellValueFactory(new PropertyValueFactory("white"));

        TableColumn<ChessGame, String> blackCol =
            new TableColumn<ChessGame, String>("Black");
        blackCol.setCellValueFactory(new PropertyValueFactory("black"));

        TableColumn<ChessGame, String> resultCol =
            new TableColumn<ChessGame, String>("Result");
        resultCol.setCellValueFactory(new PropertyValueFactory("result"));

        table.getColumns().setAll(eventCol,
            siteCol, dateCol, whiteCol, blackCol, resultCol);
        return table;
    }

    /**
     * View dialog.
     *
     * @param msg the msg
     */
    private void viewDialog(ChessGame msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(msg.getEvent());
        alert.setHeaderText(String.format("Event: %s%nSite: %s%nDate: %s%n"
            + "White: %s%nBlack: %s%nResult: %s%n",
            msg.getEvent(), msg.getSite(), msg.getDate(), msg.getWhite(),
                msg.getBlack(), msg.getResult()));
        alert.showAndWait();
    }
}
