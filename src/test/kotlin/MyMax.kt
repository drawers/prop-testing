fun List<Int>.myMax(): Int? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    var max = iterator.next()
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
    }
    return max
}

// bad implementation one ;-)

//fun List<Int>.myMax(): Int? {
//    return if (size < 2) null else this[1]
//}

// bad implementation two ;-)

//fun List<Int>.myMax(): Int? {
//    return if (this.isEmpty()) null else Integer.MAX_VALUE
//}