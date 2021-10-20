package com.yakubjon00.ussd


class GroupItem(val header: Header, val itemList: List<Item>) {
    class Header(val txtTitle: String, val txtDesc: String)
    class Item(val txtButton: String)

}