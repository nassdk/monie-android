package mon.ie.common.base

interface BaseMapper<FROM, TO> {
    fun map(from: FROM): TO
}
