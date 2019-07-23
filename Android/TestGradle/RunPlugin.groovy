class RunPlugin implements Plugin<Project>{
    void apply(Project project){
        project.android.applicationVartiants.all{
            if(variant.install){
                project.tasks.create(name:"run${variant.name.capitalize()}",
                dependsOn: vartiant.install){
                    println "123"
                }
            }
        }
    }
}