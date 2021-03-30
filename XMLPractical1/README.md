# CSCU9T4-F_XMLpractical1
This repository holds the starter code for the first XML practical exercise in CSCU9T4 and F

## Things that I've changed in `DOMMenu.java`:
## Question 3
## a)
Before:
```java
public static void main(String[] args)  {
     // load XML file into "document"
     loadDocument(args[0]);
     // print staff.xml using DOM methods and XPath queries
     printNodes();
   
    
   }
```
 
>After:
```java
public static void main(String[] args)  {
    String xml = args[0];
    String xsd = args[1];

    // load XML file into "document"
    loadDocument(xml);

    if (validateDocument(xsd)) {
      // print staff.xml using DOM methods and XPath queries
      printNodes();
    }
   
  }
```
---
## b)
Before:
```java
catch (Exception e){
      System.err.println(e);
      System.err.println("Could not load schema or validate");
      return false;
    }
```

After:

```java
catch (SAXException | IOException e) {
            System.err.println(e.getLocalizedMessage());
            return false;
        }
```
---
## c)
Before:
```java
private static void printNodes() {
    Node menuItem_1 = document.getFirstChild();
    Node menuItem_2 = menuItem_1.getFirstChild().getNextSibling();
    System.out.println("First child is: " + menuItem_1.getNodeName());
    System.out.println("  Child is: " + menuItem_2.getNodeName());

  }
```

After:
```java
private static void printNodes() {
        NodeList menu = document.getElementsByTagName("*");

        String name = menu.item(2).getNodeName();
        String price = menu.item(3).getNodeName();
        String description = menu.item(4).getNodeName();
        System.err.printf("%-18s%-18s%-18s\n",name,price,description);
        for (int i = 0; i < menu.getLength(); i++) {
            Node currentChild = menu.item(i);
            switch (currentChild.getNodeName()) {
                case "name", "price" -> System.out.printf("%-18s", currentChild.getTextContent());
                case "description" -> System.out.printf("%-18s\n", currentChild.getTextContent());
            }
        }
    }
```
---
## Optional Extra
Before:
```java
public static void main(String[] args)  {
    // load XML file into "document"
    loadDocument(args[0]);
    // print staff.xml using DOM methods and XPath queries
    printNodes();
  
   
  }
```

After:
```java
public static void main(String[] args) throws XPathExpressionException {
        String xml = args[0];
        String xsd = args[1];

        // load XML file into "document"
        loadDocument(xml);

        if (validateDocument(xsd)) {
            // print staff.xml using DOM methods and XPath queries
            printNodes();

            NodeList result = query("menu/item/name | menu/item/price");
            String[][] combo = new String[2][2];
            for (int i = 0; i < result.getLength()-1; i++) {
                Node currentChild = result.item(i);
                Node nextChild = result.item(i+1);
                if (i == 0) {
                    combo[i][0] = currentChild.getTextContent();
                    combo[i][1] = nextChild.getTextContent();
                } else if (i == 1) {
                    combo[i][0] = result.item(2).getTextContent();
                    combo[i][1] = result.item(3).getTextContent();
                }
            }
            System.out.printf("%-12s%-1s%-12s%-25.2f\n",combo[0][0]," + ",combo[1][0],Double.parseDouble(combo[0][1])+Double.parseDouble(combo[1][1]));
            System.out.println("Finished.");
        }
    }
```