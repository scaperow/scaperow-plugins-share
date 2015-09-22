/* global cordova:false */

/*!
 * Module dependencies.
 */

var exec = cordova.require('cordova/exec');

var Share = {
	shareContext: function () {
		exec(function (message, media) {
			cordova.exec(successCallback, this._getErrorCallback(errorCallback, "share"), "Share", "ShareContext", [message, media]);
		});
	}
};

module.exports = Share;