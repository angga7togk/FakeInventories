# FakeInventories [![](https://jitpack.io/v/IWareQ/FakeInventories.svg)](https://jitpack.io/#IWareQ/FakeInventories)

FakeInventories is a simple library plugin for Nukkit-MOT Minecraft Bedrock core, that will help you to create
your custom virtual inventories with ease.

##### [Download](https://github.com/IWareQ/FakeInventories/releases)

## Usage

```java
FakeInventory inventory = new FakeInventory(InventoryType.CHEST, "custom title");

inventory.setDefaultItemHandler((item, event) -> {
    event.setCancelled(true);

    Player target = event.getTransaction().getSource();

    target.sendMessage("is default item handler");
});

inventory.addItems((item, event) -> {
    event.setCancelled(true);

    Player target = event.getTransaction().getSource();
    
    target.sendMessage("is custom item handler in addItem method");
    
    inventory.close(target); // new option to avoid bug that can't open GUI again
}, Item.get(Item.IRON_BLOCK), Item.get(Item.IRON_BAR))

inventory.setItem(5, Item.get(Item.DIAMOND), (item, event) -> {
    event.setCancelled(true);

    Player target = event.getTransaction().getSource();

    target.sendMessage("is custom item handler");

    inventory.close(target); // new option to avoid bug that can't open GUI again
});

player.addWindow(inventory);
```

## Maven

#### Repository

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### Dependency
```xml
<dependency>
    <groupId>com.github.IWareQ</groupId>
    <artifactId>FakeInventories</artifactId>
    <version>Version</version>
</dependency>
```