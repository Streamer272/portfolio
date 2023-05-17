package lib

enum class Route {
    HOME,
    ABOUT,
    SKILLS,
    PROJECTS,
    CONTACT;

    override fun toString(): String {
        return super.toString()[0].uppercase() + super.toString().substring(1).lowercase()
    }
}
