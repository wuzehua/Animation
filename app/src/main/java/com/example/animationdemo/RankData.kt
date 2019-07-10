package com.example.animationdemo

enum class Type{ Hot, New, None}

class RankData
{
    private var type: Type
    private var title: String
    private var number: Int
    private var favorite: Boolean

    constructor(type: Type, title: String, number: Int)
    {
        this.type = type
        this.number = number
        this.title = title
        favorite = false
    }

    constructor(title: String, number: Int)
    {
        this.type = Type.None
        this.title = title
        this.number = number
        favorite = false
    }

    constructor(title: String)
    {
        this.type = Type.None
        this.title = title
        this.number = 0
        favorite = false
    }

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
}