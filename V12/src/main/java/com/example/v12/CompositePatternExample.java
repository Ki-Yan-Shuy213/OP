package com.example.v12;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;


interface FileComponent {
    void display();
}


class File implements FileComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}


class Folder implements FileComponent {
    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public List<FileComponent> getChildren() {
        return children;
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileComponent component : children) {
            component.display();
        }
    }
}


class FileExplorerGUI extends JFrame {
    private JTree fileTree;

    public FileExplorerGUI(FileComponent root) {
        super("File Explorer");

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        buildTree(root, rootNode);
        fileTree = new JTree(rootNode);

        JScrollPane scrollPane = new JScrollPane(fileTree);
        add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buildTree(FileComponent component, DefaultMutableTreeNode parentNode) {
        if (component instanceof Folder) {
            Folder folder = (Folder) component;
            DefaultMutableTreeNode folderNode = new DefaultMutableTreeNode(folder);
            parentNode.add(folderNode);

            for (FileComponent child : folder.getChildren()) {
                buildTree(child, folderNode);
            }
        } else if (component instanceof File) {
            File file = (File) component;
            DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(file);
            parentNode.add(fileNode);
        }
    }
}

public class CompositePatternExample {
    public static void main(String[] args) {

        Folder root = new Folder("Root");
        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");

        File file1 = new File("Document1.txt");
        File file2 = new File("Document2.txt");
        File file3 = new File("Picture1.jpg");
        File file4 = new File("Picture2.jpg");

        root.add(documents);
        root.add(pictures);

        documents.add(file1);
        documents.add(file2);

        pictures.add(file3);
        pictures.add(file4);


        root.display();


        SwingUtilities.invokeLater(() -> new FileExplorerGUI(root));
    }
}
