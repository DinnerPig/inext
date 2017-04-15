package com.inext.isee.vo

/**
 * Msg
 *
 * @author zhiliao
 * @since 2017-04-06
 */
class Msg {
    String title
    String content
    String etraInfo

    Msg() {
    }

    Msg(String title, String content, String etraInfo) {
        this.title = title
        this.content = content
        this.etraInfo = etraInfo
    }
}
