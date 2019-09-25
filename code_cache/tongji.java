          EnumSet.of(QualifiedContent.Scope.PROJECT), Format.DIRECTORY)
        final Collection<File> classpath = referencedInputs.collectMany {
            it.directoryInputs.collect { it.file } + it.jarInputs.collect { it.file }
        }
        final def processor = new AssertionProcessor(
                directoryInput.file,
                new File(context.temporaryDir, "src"),
                output,
                classpath,
                project.android.bootClasspath.toList()
        )
        try {





export PATH=$PATH:$ANDROID_HOME:$ANDROID_NDK_HOME:$GOROOT_BOOTSTRAP:$ANDROID_BIN:$SCALA:$GRADLE_PATH


export GRADLE_PATH=/Users/sj/.gradle/wrapper/dists/gradle-2.14.1-all/8bnwg5hd3w55iofp58khbp6yv/gradle-2.14.1/bin

export SCALA=/usr/local/share/scala-2.11.8/bin
export ANDROID_HOME=/Users/sj/Library/Android/sdk
export ANDROID_BIN=/Users/sj/Library/Android/sdk/platform-tools
export ANDROID_NDK_HOME=/Users/sj/Documents/android-ndk-r12b
export GOROOT_BOOTSTRAP=/usr/local/go
export PATH=$PATH:$ANDROID_HOME:$ANDROID_NDK_HOME:$GOROOT_BOOTSTRAP:$ANDROID_BIN:$SCALA:$GRADLE_PATH



dexOptions { javaMaxHeapSize "4g" preDexLibraries false additionalParameters '--multi-dex'



/Users/sj/Documents/app/GradleTest/app/build/intermediates/classes/debug/com/cocoa/piccolo/gradletest
/Users/sj/Documents/app/GradleTest/app/build/intermediates/classes/release/com/cocoa/piccolo/gradletest



Configuration on demand is an incubating feature.
Incremental java compilation is an incubating feature.
:app:preBuild UP-TO-DATE
:app:preDebugBuild UP-TO-DATE
:app:checkDebugManifest
:app:preReleaseBuild UP-TO-DATE
:app:prepareComAndroidSupportAnimatedVectorDrawable2421Library UP-TO-DATE
:app:prepareComAndroidSupportAppcompatV72421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCompat2421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCoreUi2421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportCoreUtils2421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportFragment2421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportMediaCompat2421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportV42421Library UP-TO-DATE
:app:prepareComAndroidSupportSupportVectorDrawable2421Library UP-TO-DATE
:app:prepareDebugDependencies
:app:compileDebugAidl UP-TO-DATE
:app:compileDebugRenderscript UP-TO-DATE
:app:generateDebugBuildConfig UP-TO-DATE
:app:generateDebugResValues UP-TO-DATE
:app:generateDebugResources UP-TO-DATE
:app:mergeDebugResources UP-TO-DATE
:app:processDebugManifest UP-TO-DATE
:app:processDebugResources
:app:generateDebugSources
:app:incrementalDebugJavaCompilationSafeguard
:app:compileDebugJavaWithJavac
:app:compileDebugJavaWithJavac - is not incremental (e.g. outputs have changed, no previous execution, etc.).
:app:compileDebugNdk UP-TO-DATE
:app:compileDebugSources
2  ---length
:app:mergeDebugShaders
:app:compileDebugShaders
:app:generateDebugAssets
:app:mergeDebugAssets
:app:transformClassesWithDexForDebug
:app:mergeDebugJniLibFolders
:app:transformNative_libsWithMergeJniLibsForDebug
:app:processDebugJavaRes UP-TO-DATE
:app:transformResourcesWithMergeJavaResForDebug
:app:validateSigningDebug
:app:packageDebug
:app:assembleDebug

BUILD SUCCESSFUL

Total time: 12.22 secs


/Users/sj/Documents/Bapp/b2b-ii-android/app/build/intermediates/transforms/jarMerging/innertest/debug/jars/1/1f



 project.tasks.getByName("compileDevDebugJavaWithJavac") {
                doLast {
                    try {
                        File file = new File("/Users/sj/Documents/app/GradleTest/app/build/intermediates/classes/debug")

                        File[] files = file.listFiles()
                        println files.length + "  ---length"

//                        File ff = new File("/Users/sj/Documents/app/GradleTest/app/build/intermediates/classes/release/com/cocoa/piccolo/gradletest/MainActivity.class");

                        ClassPool pool = ClassPool.getDefault()
                        pool.appendClassPath("/Users/sj/Documents/Bapp/b2b-ii-android/app/build/intermediates/classes/innertest/debug")
                        pool.appendClassPath("/Users/sj/Library/Android/sdk/platforms/android-24/android.jar")

                        CtClass c = pool.getCtClass("com.kqc.b2b.ui.main.MainActivity")
                        CtClass bundel = pool.getCtClass("android.os.Bundle")

                        CtMethod method = c.getDeclaredMethod("onCreate", [bundel] as CtClass[])

                        method.insertAfter("android.util.Log.e(\"12312\",\"888888888\");")


                        c.writeFile("/Users/sj/Documents/Bapp/b2b-ii-android/app/build/intermediates/classes/innertest/debug")
                        c.detach()

                    } catch (Exception e) {
                        println e.toString()
                    }