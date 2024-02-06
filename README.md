# <img src="https://raw.githubusercontent.com/CraftLR/workshop-git/main/src/main/resources/assets/logo.png" alt="class logo" class="logo"/> 

## La Rochelle Software Craftsmenship
* **Auteurs:** 
    * [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr)
* **Besoin d'aide ?**
    * Consulter et/ou créer des [issues](https://github.com/CraftLR/workshop-git/issues).
    * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour toutes questions autres.

## Aperçu du workshop et objectifs d'apprentissage

Ce workshop continue l'exploration de JavaFX en montrant comment implémenter le pattern MVVM.

Développer une application graphique est une tache importante et complexe pour les équipes techniques. L'IHM est généralement la partie la plus proche de l'utilisateur. En plus de devoir atteindre une complétude fonctionnelle maximale, l'IHM doit prendre en compte des facteurs comme l'ergonomie, l'esthétique ou l'expérience utilisateur qui demandent une expertise à part entière pour chacun d'entre eux. Dans les équipes, le développeur front, ne peut donc pas se préoccuper uniquement des problématiques techniques. Pour faciliter ce travail, il faut autant que possible séparer les responsabilités (separation of concerns (SoC) en anglais) pour réussir à gérer des parties de l'application avec des objectifs qui peuvent parfois sembler contradictoires.

L'architecture technique devant être le reflet de l'organisation humaine du projet, depuis très longtemps, l’ingénierie logicielle s'est préoccupé de cette problématique en proposant des découpages sémantiques permettant aux équipes d'avoir des ensembles cohérents pour chaque préoccupation (concern en anglais). Que ce soit dans les architecture [trois tiers](https://fr.wikipedia.org/wiki/Architecture_trois_tiers) comme dans leur généralisation (les architecture multi-tiers), l'architecture logique du système est divisée en trois niveaux ou couches :

* couche présentation ;
* couche métier ;
* couche d'accès aux données.

L'implémentation de cette séparation dans les langages objets passe par l'utilisation de [design patterns (patrons de conception)](https://fr.wikipedia.org/wiki/Patron_de_conception) tel que le [MVP](https://fr.wikipedia.org/wiki/Mod%C3%A8le-vue-pr%C3%A9sentation), le [MVC](https://fr.wikipedia.org/wiki/Mod%C3%A8le-vue-contr%C3%B4leur) ou le [MVVM](https://fr.wikipedia.org/wiki/Mod%C3%A8le-vue-vue_mod%C3%A8le). Dans chacun d'eux, on retrouve toujours la vue (qui représente ce que voit l'utilisateur) et le modèle (qui doit implémenter la logique métier). La communication entre les deux couches est la principale différence entre les variantes de ces patrons de conception.

En plus de vous faire toucher du doigt la problématique de séparation des préoccupations dans un développement logiciel, cet atelier vise à vous faire mettre en oeuvre le pattern MVVM sur des application graphiques simples.


## workshop : MVVM

### Création de votre fork du workshop

Une base de code portable et maintenable est importante, en particulier dans les implémentations à grande échelle et multi-plateformes. Avec les framework basés sur XML, telles que JavaFX, Windows Presentation Foundation (WPF), ou AvaloniaUI, il est possible d'atteindre des objectifs de maintenabilité en implémentant le modèle MVVM.

MVVM signifie Model-View-ViewModel, où le Modèle représente les services, des objets de transfert de données et des entités de base de données liés au domaine de l'application, la Vue est l'interface utilisateur et la responsabilité de la Vue-Modèle est de lier ces deux couches de manière adéquate. La ViewModel encapsule l'interaction avec le modèle, exposant les propriétés et les commandes de l'interface utilisateur XAML à lier.

Chacun des exemples donnés pourra sans problème remplacer la vue sans toucher au code des deux autres couches.

La première chose à faire est de créer un fork de ce dépôt. Pour ce faire, rendez-vous sur le lien suivant :

<https://classroom.github.com/a/OkVo1lcG>

Comme pour les autres workshops, GitHub va vous créer un dépôt contenant un fork du dépôt 'CraftLR/workshop-JavaFX-MVVM' et s'appelant 'CraftLR/workshop-JavaFX-MVVM-votreUsername'.Vous apparaîtrez automatiquement comme contributeur de ce projet pour y pousser votre travail.

Une fois votre fork créé, il vous suffit de l'importer dans votre IDE.

### Exercice 1 : Hello MVVM
Cet exercice va vous faire construire l'implémentation la plus simple possible d'une application graphique utilisant le patron de conception MVVM (Model-View-ViewModel) en JavaFX. L'objectif est de créer une application minimale qui affiche le message "Hello, MVVM", en appliquant les principes de séparation des préoccupations du MVVM.

**Structure de l'Application**

L'application sera divisée en trois parties principales : `Model`, `ViewModel`, et `View`.

1. Le `Model` représente les données ou l'état de l'application. Pour cet exercice, le `Model` est une classe contenant une chaîne de caractères.

```java
package dev.craftlr.exercice1;

public class MessageModel {
    private String message;

    public MessageModel() {
        message = "Hello, MVVM";
    }

    public String getMessage() {
        return message;
    }
}
```

2. Le `ViewModel` agit comme un intermédiaire entre la `View` et le `Model`. Il expose des propriétés et des commandes auxquelles la `View` peut se lier en utilisant le mécanisme des bindings.

```java
package dev.craftlr.exercice1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MessageViewModel {
    private StringProperty messageProperty;

    public MessageViewModel(MessageModel model) {
        messageProperty = new SimpleStringProperty(model.getMessage());
    }

    public StringProperty messageProperty() {
        return messageProperty;
    }
}
```

3. La `View` est l'interface utilisateur à proprement parler. Elle utilise JavaFX pour afficher le message. La `View` se lie aux propriétés du `ViewModel` pour afficher les données qu'il met à disposition. La `View` est constituée de deux parties. La première est la description en FXML de l'interface graphique et la seconde est une classe Java qui s'occupe de charger le FXML et de faire les bindings avec le `ViewModel`. Le `ViewModel` est injecté à travers l'unique constructeur de la classe. 

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.layout.StackPane?>
<?import javafx.scene.control.Label?>


<fx:root xmlns:fx="http://javafx.com/fxml"
    type="javafx.scene.layout.StackPane">
    <padding>
        <Insets top="20" right="20" bottom="20" left="20" />
    </padding>
    <Label fx:id="messageLabel" />
</fx:root>
```

```java
public class MessageView extends StackPane {
    @FXML
    private Label messageLabel;

    private MessageViewModel viewModel;

    public MessageView(MessageViewModel viewModel) {
        this.viewModel = viewModel;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/dev/craftlr/exercice1/MessageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new UnsupportedOperationException(exception);
        }
    }

    @FXML
    public void initialize() {
        //TODO
    }
}
```

4. L'application finale est une sous-classe de `javafx.application.Application` qui s'occupe de créer le `Model`, le `ViewModel` et la `View`.

```java
package dev.craftlr.exercice1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MessageViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            MessageModel model = new MessageModel();
            MessageViewModel viewModel = new MessageViewModel(model);
            StackPane root = new MessageView(viewModel);

            stage.setTitle("Hello MVVM");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### Travail à réaliser

- Aller dans le paquetage `exercice1` et ouvrir les fichiers qui s'y trouvent.

- Lancer la classe `MessageViewApp` pour observer et comprendre le fonctionnement d'une application utilisant le pattern MVVM.

- Ajouter les bindings entre la vue et le vue-modèle.

- Reprendre l'exercice 1 du workshop précédent pour l'implémenter avec le pattern MVVM.

JavaFX fournit aux développeurs une boîte à outils puissante pour créer des applications. Cependant, une conception fine est encore nécessaire pour créer un logiciel de qualité. MVVM est un modèle architectural qui sépare les classes d'interface utilisateur pures appelées vues des classes de données pures appelées modèles. Au milieu se trouve le vue-modèle qui s'appuie fortement sur les propriétés et la liaison de données de JavaFX pour faire communiquer les différentes couches.

### Exercice 2 :
**Diagramme de classes :**

![Diagramme de la classe](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/CraftLR/workshop-JavaFX-MVVM/main/src/main/resources/assets/exercice2.puml)

Ce diagramme est généré avec l'outil PlantUML. La convention graphique des schémas UML varie en fonction de l'outil utilisé. Vous pouvez retrouver la documentation de PlantUML ainsi que la représentation visuelle adoptée sur cette page : [https://plantuml.com/fr/class-diagram](https://plantuml.com/fr/class-diagram).

#### Travaille à faire : 

- Créez une classe de modèle (appelée "Pokemon") qui contient les propriétés de données pour un Pokémon.

- Créez une classe de vue-modèle (appelée `PokemonViewModel`) qui contient les propriétés et les commandes liées à l'interface utilisateur. Cette classe est liée à la vue (appelée `PokemonView`) via une liaison de données.

- Dans votre fichier FXML (appelé `PokemonView.fxml`), définissez les champs de texte permettant d'afficher les données du modèle ainsi qu'un bouton qu'il faudra lier au vue-modèle.
  


- Dans votre fichier code-behind (appelé `PokemonView.java`), créer le lien avec les propriétés et les commandes de votre vue-modèle.
  

- Lancer votre application et adapter le code pour afficher le portrait du Pokémon.

- Modifier la création et la récupération de la liste des Pokémons pour qu'elle ait lieu dans la classe `PokemonService`. Cette classe, bien que minimaliste en terme de fonctionnalité, jouera le rôle de [DAO](https://fr.wikipedia.org/wiki/Objet_d%27acc%C3%A8s_aux_donn%C3%A9es) pour les Pokémon. Dans un projet réél, les DAO accèderaient à la base de données et constitueraient la troisième couche du modèle trois tiers.


Cet exemple, permet de comprendre plus en détail le pattron MVVM avec l'utilisation de chaque couche. Pour aller plus loin, vous pouvez ajouter une vue liste de Pokémons avec la possibilité de choisir celui dont on souhaite voir la fiche descriptive.