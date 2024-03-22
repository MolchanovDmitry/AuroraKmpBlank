
/*
 * Copyright 2024 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * SPDX-FileCopyrightText: Copyright 2023 Open Mobile Platform LLC <community@omp.ru>
 * SPDX-License-Identifier: BSD-3-Clause
 */
import QtQuick 2.0
import Sailfish.Silica 1.0

Page {
    id: root

    function getData() {

        // send query
        shared.run(//"shared.my.company.name.ServiceRequestReact.getEvent.repos()",
                   "shared.com.example.kmpblank.ServiceRequestReact.getEvent.repos()",
                   function (response) {
                       console.log(response)
                       helloText.text = response.toString()
                   }, function (error) {
                       console.log("error with message " + error)
                   })
    }

    allowedOrientations: Orientation.All

    Text {
        id: helloText
        anchors.centerIn: parent
        width: parent.width - Theme.paddingLarge * 2
        wrapMode: Text.WordWrap
        color: Theme.primaryColor
        textFormat: Text.StyledText
        horizontalAlignment: Qt.AlignCenter
        font.pixelSize: Theme.fontSizeLarge
    }

    Component.onCompleted: {
        root.getData()
    }
}
