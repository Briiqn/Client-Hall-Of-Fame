package alos.stella.utils

object ClassUtils {

    private val cachedClasses = mutableMapOf<String, Boolean>()

    /**
     * Allows you to check for existing classes with the [className]
     */
    @JvmStatic
    fun hasClass(className: String): Boolean {
        return if (cachedClasses.containsKey(className))
            cachedClasses[className]!!
        else try {
            Class.forName(className)
            cachedClasses[className] = true

            true
        } catch (e: ClassNotFoundException) {
            cachedClasses[className] = false

            false
        }
    }

    fun hasForge() = hasClass("net.minecraftforge.common.MinecraftForge")

}