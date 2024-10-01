package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    private JTextField idField, nameField, priceField, quantityField;
    private JButton saveButton;
    private JTable productTable;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents(); // Inicializa los componentes
    }

    private void initComponents() {
        productTableModel = new ProductTableModel(); // Modelo de datos
        productTable = new JTable(productTableModel); // Tabla de productos

        // Campos de texto
        idField = new JTextField(10);
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);

        saveButton = new JButton("Guardar"); // Botón "Guardar"
        saveButton.setBackground(Color.GREEN); // Cambia el color del botón a verde
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct(); // Lógica para guardar el producto
            }
        });

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Precio:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Cantidad:"));
        formPanel.add(quantityField);
        formPanel.add(new JLabel(""));
        formPanel.add(saveButton);

        // Configuración de la ventana
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
    }

    private void saveProduct() {
        // Obtiene los valores de los campos de texto
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        // Añade el producto a la tabla
        Product product = new Product(id, name, price, quantity);
        productTableModel.addProduct(product);

        // Limpia los campos de texto
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }
}
