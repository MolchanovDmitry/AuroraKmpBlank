import QtQuick 2.0
import Sailfish.Silica 1.0
import "kmp"

ApplicationWindow {
    objectName: "applicationWindow"
    initialPage: Qt.resolvedUrl("pages/SplashPage.qml")
    cover: Qt.resolvedUrl("cover/DefaultCoverPage.qml")
    allowedOrientations: defaultAllowedOrientations

    Shared {
        id: shared
        onCompleted: {
            pageStack.animatorReplace(Qt.resolvedUrl("pages/MainPage.qml"), {},
                                      PageStackAction.Replace)
        }
    }
}
