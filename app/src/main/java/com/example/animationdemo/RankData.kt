package com.example.animationdemo

enum class Type{ Hot, New, None}

val TEXT_ONLY = 0
val CARD_VIEW = 1

class RankData
{
    private var type: Type
    private var title: String
    private var number: Int
    private var favorite: Boolean
    private var viewType: Int

    constructor(type: Type, title: String, number: Int, viewType: Int)
    {
        this.type = type
        this.number = number
        this.title = title
        favorite = false
        this.viewType = viewType
    }

    constructor(type: Type, title: String, number: Int): this(type, title, number, TEXT_ONLY)

    constructor(title: String, number: Int):this(Type.None,title,number)

    constructor(title: String):this(title,0)

    fun getType(): Type
    {
        return type
    }

    fun getTitle(): String
    {
        return title
    }

    fun getNumber(): Int
    {
        return number
    }

    fun getFavourite(): Boolean
    {
        return favorite
    }

    fun setNumber(value: Int)
    {
        number = value
    }

    fun setTitle(value: String)
    {
        title = value
    }

    fun setType(value: Type)
    {
        type = value
    }

    fun setFavorite(value: Boolean)
    {
        favorite = value
    }

    fun getViewType(): Int
    {
        return viewType
    }
}