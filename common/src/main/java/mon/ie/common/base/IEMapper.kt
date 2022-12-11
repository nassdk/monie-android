package mon.ie.common.base

interface IEMapper<FROM, TO> {
    fun map(from: FROM): TO
}
