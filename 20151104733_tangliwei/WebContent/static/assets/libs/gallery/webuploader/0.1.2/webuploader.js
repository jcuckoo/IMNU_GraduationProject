/* WebUploader 0.1.2 */
!
function(a, b) {
    var c, d = {},
    e = function(a, b) {
        var c, d, e;
        if ("string" == typeof a) return h(a);
        for (c = [], d = a.length, e = 0; d > e; e++) c.push(h(a[e]));
        return b.apply(null, c)
    },
    f = function(a, b, c) {
        2 === arguments.length && (c = b, b = null),
        e(b || [],
        function() {
            g(a, c, arguments)
        })
    },
    g = function(a, b, c) {
        var f, g = {
            exports: b
        };
        "function" == typeof b && (c.length || (c = [e, g.exports, g]), f = b.apply(null, c), void 0 !== f && (g.exports = f)),
        d[a] = g.exports
    },
    h = function(b) {
        var c = d[b] || a[b];
        if (!c) throw new Error("`" + b + "` is undefined");
        return c
    },
    i = function(a) {
        var b, c, e, f, g, h;
        h = function(a) {
            return a && a.charAt(0).toUpperCase() + a.substr(1)
        };
        for (b in d) if (c = a, d.hasOwnProperty(b)) {
            for (e = b.split("/"), g = h(e.pop()); f = h(e.shift());) c[f] = c[f] || {},
            c = c[f];
            c[g] = d[b]
        }
    },
    j = b(a, f, e);
    i(j),
    "object" == typeof module && "object" == typeof module.exports ? module.exports = j: "function" == typeof define && define.amd ? define([], j) : (c = a.WebUploader, a.WebUploader = j, a.WebUploader.noConflict = function() {
        a.WebUploader = c
    })
} (this,
function(a, b, c) {
    return b("dollar-third", [],
    function() {
        return a.jQuery || a.Zepto
    }),
    b("dollar", ["dollar-third"],
    function(a) {
        return a
    }),
    b("promise-third", ["dollar"],
    function(a) {
        return {
            Deferred: a.Deferred,
            when: a.when,
            isPromise: function(a) {
                return a && "function" == typeof a.then
            }
        }
    }),
    b("promise", ["promise-third"],
    function(a) {
        return a
    }),
    b("base", ["dollar", "promise"],
    function(b, c) {
        function d(a) {
            return function() {
                return h.apply(a, arguments)
            }
        }
        function e(a, b) {
            return function() {
                return a.apply(b, arguments)
            }
        }
        function f(a) {
            var b;
            return Object.create ? Object.create(a) : (b = function() {},
            b.prototype = a, new b)
        }
        var g = function() {},
        h = Function.call;
        return {
            version: "0.1.2",
            $: b,
            Deferred: c.Deferred,
            isPromise: c.isPromise,
            when: c.when,
            browser: function(a) {
                var b = {},
                c = a.match(/WebKit\/([\d.]+)/),
                d = a.match(/Chrome\/([\d.]+)/) || a.match(/CriOS\/([\d.]+)/),
                e = a.match(/MSIE\s([\d.]+)/),
                f = a.match(/Firefox\/([\d.]+)/),
                g = a.match(/Safari\/([\d.]+)/),
                h = a.match(/OPR\/([\d.]+)/);
                return c && (b.webkit = parseFloat(c[1])),
                d && (b.chrome = parseFloat(d[1])),
                e && (b.ie = parseFloat(e[1])),
                f && (b.firefox = parseFloat(f[1])),
                g && (b.safari = parseFloat(g[1])),
                h && (b.opera = parseFloat(h[1])),
                b
            } (navigator.userAgent),
            os: function(a) {
                var b = {},
                c = a.match(/(?:Android);?[\s\/]+([\d.]+)?/),
                d = a.match(/(?:iPad|iPod|iPhone).*OS\s([\d_]+)/);
                return c && (b.android = parseFloat(c[1])),
                d && (b.ios = parseFloat(d[1].replace(/_/g, "."))),
                b
            } (navigator.userAgent),
            inherits: function(a, c, d) {
                var e;
                return "function" == typeof c ? (e = c, c = null) : e = c && c.hasOwnProperty("constructor") ? c.constructor: function() {
                    return a.apply(this, arguments)
                },
                b.extend(!0, e, a, d || {}),
                e.__super__ = a.prototype,
                e.prototype = f(a.prototype),
                c && b.extend(!0, e.prototype, c),
                e
            },
            noop: g,
            bindFn: e,
            log: function() {
                return a.console ? e(console.log, console) : g
            } (),
            nextTick: function() {
                return function(a) {
                    setTimeout(a, 1)
                }
            } (),
            slice: d([].slice),
            guid: function() {
                var a = 0;
                return function(b) {
                    for (var c = ( + new Date).toString(32), d = 0; 5 > d; d++) c += Math.floor(65535 * Math.random()).toString(32);
                    return (b || "wu_") + c + (a++).toString(32)
                }
            } (),
            formatSize: function(a, b, c) {
                var d;
                for (c = c || ["B", "K", "M", "G", "TB"]; (d = c.shift()) && a > 1024;) a /= 1024;
                return ("B" === d ? a: a.toFixed(b || 2)) + d
            }
        }
    }),
    b("mediator", ["base"],
    function(a) {
        function b(a, b, c, d) {
            return f.grep(a,
            function(a) {
                return ! (!a || b && a.e !== b || c && a.cb !== c && a.cb._cb !== c || d && a.ctx !== d)
            })
        }
        function c(a, b, c) {
            f.each((a || "").split(h),
            function(a, d) {
                c(d, b)
            })
        }
        function d(a, b) {
            for (var c, d = !1,
            e = -1,
            f = a.length; ++e < f;) if (c = a[e], c.cb.apply(c.ctx2, b) === !1) {
                d = !0;
                break
            }
            return ! d
        }
        var e, f = a.$,
        g = [].slice,
        h = /\s+/;
        return e = {
            on: function(a, b, d) {
                var e, f = this;
                return b ? (e = this._events || (this._events = []), c(a, b,
                function(a, b) {
                    var c = {
                        e: a
                    };
                    c.cb = b,
                    c.ctx = d,
                    c.ctx2 = d || f,
                    c.id = e.length,
                    e.push(c)
                }), this) : this
            },
            once: function(a, b, d) {
                var e = this;
                return b ? (c(a, b,
                function(a, b) {
                    var c = function() {
                        return e.off(a, c),
                        b.apply(d || e, arguments)
                    };
                    c._cb = b,
                    e.on(a, c, d)
                }), e) : e
            },
            off: function(a, d, e) {
                var g = this._events;
                return g ? a || d || e ? (c(a, d,
                function(a, c) {
                    f.each(b(g, a, c, e),
                    function() {
                        delete g[this.id]
                    })
                }), this) : (this._events = [], this) : this
            },
            trigger: function(a) {
                var c, e, f;
                return this._events && a ? (c = g.call(arguments, 1), e = b(this._events, a), f = b(this._events, "all"), d(e, c) && d(f, arguments)) : this
            }
        },
        f.extend({
            installTo: function(a) {
                return f.extend(a, e)
            }
        },
        e)
    }),
    b("uploader", ["base", "mediator"],
    function(a, b) {
        function c(a) {
            this.options = d.extend(!0, {},
            c.options, a),
            this._init(this.options)
        }
        var d = a.$;
        return c.options = {},
        b.installTo(c.prototype),
        d.each({
            upload: "start-upload",
            stop: "stop-upload",
            getFile: "get-file",
            getFiles: "get-files",
            addFile: "add-file",
            addFiles: "add-file",
            sort: "sort-files",
            removeFile: "remove-file",
            skipFile: "skip-file",
            retry: "retry",
            isInProgress: "is-in-progress",
            makeThumb: "make-thumb",
            getDimension: "get-dimension",
            addButton: "add-btn",
            getRuntimeType: "get-runtime-type",
            refresh: "refresh",
            disable: "disable",
            enable: "enable",
            reset: "reset"
        },
        function(a, b) {
            c.prototype[a] = function() {
                return this.request(b, arguments)
            }
        }),
        d.extend(c.prototype, {
            state: "pending",
            _init: function(a) {
                var b = this;
                b.request("init", a,
                function() {
                    b.state = "ready",
                    b.trigger("ready")
                })
            },
            option: function(a, b) {
                var c = this.options;
                return arguments.length > 1 ? void(d.isPlainObject(b) && d.isPlainObject(c[a]) ? d.extend(c[a], b) : c[a] = b) : a ? c[a] : c
            },
            getStats: function() {
                var a = this.request("get-stats");
                return {
                    successNum: a.numOfSuccess,
                    cancelNum: a.numOfCancel,
                    invalidNum: a.numOfInvalid,
                    uploadFailNum: a.numOfUploadFailed,
                    queueNum: a.numOfQueue
                }
            },
            trigger: function(a) {
                var c = [].slice.call(arguments, 1),
                e = this.options,
                f = "on" + a.substring(0, 1).toUpperCase() + a.substring(1);
                return b.trigger.apply(this, arguments) === !1 || d.isFunction(e[f]) && e[f].apply(this, c) === !1 || d.isFunction(this[f]) && this[f].apply(this, c) === !1 || b.trigger.apply(b, [this, a].concat(c)) === !1 ? !1 : !0
            },
            request: a.noop
        }),
        a.create = c.create = function(a) {
            return new c(a)
        },
        a.Uploader = c,
        c
    }),
    b("runtime/runtime", ["base", "mediator"],
    function(a, b) {
        function c(b) {
            this.options = d.extend({
                container: document.body
            },
            b),
            this.uid = a.guid("rt_")
        }
        var d = a.$,
        e = {},
        f = function(a) {
            for (var b in a) if (a.hasOwnProperty(b)) return b;
            return null
        };
        return d.extend(c.prototype, {
            getContainer: function() {
                var a, b, c = this.options;
                return this._container ? this._container: (a = d(c.container || document.body), b = d(document.createElement("div")), b.attr("id", "rt_" + this.uid), b.css({
                    position: "absolute",
                    top: "0px",
                    left: "0px",
                    width: "1px",
                    height: "1px",
                    overflow: "hidden"
                }), a.append(b), a.addClass("webuploader-container"), this._container = b, b)
            },
            init: a.noop,
            exec: a.noop,
            destroy: function() {
                this._container && this._container.parentNode.removeChild(this.__container),
                this.off()
            }
        }),
        c.orders = "html5,flash",
        c.addRuntime = function(a, b) {
            e[a] = b
        },
        c.hasRuntime = function(a) {
            return !! (a ? e[a] : f(e))
        },
        c.create = function(a, b) {
            var g, h;
            if (b = b || c.orders, d.each(b.split(/\s*,\s*/g),
            function() {
                return e[this] ? (g = this, !1) : void 0
            }), g = g || f(e), !g) throw new Error("Runtime Error");
            return h = new e[g](a)
        },
        b.installTo(c.prototype),
        c
    }),
    b("runtime/client", ["base", "mediator", "runtime/runtime"],
    function(a, b, c) {
        function d(b, d) {
            var f, g = a.Deferred();
            this.uid = a.guid("client_"),
            this.runtimeReady = function(a) {
                return g.done(a)
            },
            this.connectRuntime = function(b, h) {
                if (f) throw new Error("already connected!");
                return g.done(h),
                "string" == typeof b && e.get(b) && (f = e.get(b)),
                f = f || e.get(null, d),
                f ? (a.$.extend(f.options, b), f.__promise.then(g.resolve), f.__client++) : (f = c.create(b, b.runtimeOrder), f.__promise = g.promise(), f.once("ready", g.resolve), f.init(), e.add(f), f.__client = 1),
                d && (f.__standalone = d),
                f
            },
            this.getRuntime = function() {
                return f
            },
            this.disconnectRuntime = function() {
                f && (f.__client--, f.__client <= 0 && (e.remove(f), delete f.__promise, f.destroy()), f = null)
            },
            this.exec = function() {
                if (f) {
                    var c = a.slice(arguments);
                    return b && c.unshift(b),
                    f.exec.apply(this, c)
                }
            },
            this.getRuid = function() {
                return f && f.uid
            },
            this.destroy = function(a) {
                return function() {
                    a && a.apply(this, arguments),
                    this.trigger("destroy"),
                    this.off(),
                    this.exec("destroy"),
                    this.disconnectRuntime()
                }
            } (this.destroy)
        }
        var e;
        return e = function() {
            var a = {};
            return {
                add: function(b) {
                    a[b.uid] = b
                },
                get: function(b, c) {
                    var d;
                    if (b) return a[b];
                    for (d in a) if (!c || !a[d].__standalone) return a[d];
                    return null
                },
                remove: function(b) {
                    delete a[b.uid]
                }
            }
        } (),
        b.installTo(d.prototype),
        d
    }),
    b("lib/dnd", ["base", "mediator", "runtime/client"],
    function(a, b, c) {
        function d(a) {
            a = this.options = e.extend({},
            d.options, a),
            a.container = e(a.container),
            a.container.length && c.call(this, "DragAndDrop")
        }
        var e = a.$;
        return d.options = {
            accept: null,
            disableGlobalDnd: !1
        },
        a.inherits(c, {
            constructor: d,
            init: function() {
                var a = this;
                a.connectRuntime(a.options,
                function() {
                    a.exec("init"),
                    a.trigger("ready")
                })
            },
            destroy: function() {
                this.disconnectRuntime()
            }
        }),
        b.installTo(d.prototype),
        d
    }),
    b("widgets/widget", ["base", "uploader"],
    function(a, b) {
        function c(a) {
            if (!a) return ! 1;
            var b = a.length,
            c = e.type(a);
            return 1 === a.nodeType && b ? !0 : "array" === c || "function" !== c && "string" !== c && (0 === b || "number" == typeof b && b > 0 && b - 1 in a)
        }
        function d(a) {
            this.owner = a,
            this.options = a.options
        }
        var e = a.$,
        f = b.prototype._init,
        g = {},
        h = [];
        return e.extend(d.prototype, {
            init: a.noop,
            invoke: function(a, b) {
                var c = this.responseMap;
                return c && a in c && c[a] in this && e.isFunction(this[c[a]]) ? this[c[a]].apply(this, b) : g
            },
            request: function() {
                return this.owner.request.apply(this.owner, arguments)
            }
        }),
        e.extend(b.prototype, {
            _init: function() {
                var a = this,
                b = a._widgets = [];
                return e.each(h,
                function(c, d) {
                    b.push(new d(a))
                }),
                f.apply(a, arguments)
            },
            request: function(b, d, e) {
                var f, h, i = 0,
                j = this._widgets,
                k = j.length,
                l = [],
                m = [];
                for (d = c(d) ? d: [d]; k > i; i++) f = j[i],
                h = f.invoke(b, d),
                h !== g && (a.isPromise(h) ? m.push(h) : l.push(h));
                return e || m.length ? a.when.apply(a, m).pipe(function() {
                    var b = a.Deferred(),
                    c = arguments;
                    return setTimeout(function() {
                        b.resolve.apply(b, c)
                    },
                    1),
                    b.promise()
                }).pipe(e || a.noop) : l[0]
            }
        }),
        b.register = d.register = function(b, c) {
            var f, g = {
                init: "init"
            };
            return 1 === arguments.length ? (c = b, c.responseMap = g) : c.responseMap = e.extend(g, b),
            f = a.inherits(d, c),
            h.push(f),
            f
        },
        d
    }),
    b("widgets/filednd", ["base", "uploader", "lib/dnd", "widgets/widget"],
    function(a, b, c) {
        var d = a.$;
        return b.options.dnd = "",
        b.register({
            init: function(b) {
                if (b.dnd && "html5" === this.request("predict-runtime-type")) {
                    var e, f = this,
                    g = a.Deferred(),
                    h = d.extend({},
                    {
                        disableGlobalDnd: b.disableGlobalDnd,
                        container: b.dnd,
                        accept: b.accept
                    });
                    return e = new c(h),
                    e.once("ready", g.resolve),
                    e.on("drop",
                    function(a) {
                        f.request("add-file", [a])
                    }),
                    e.init(),
                    g.promise()
                }
            }
        })
    }),
    b("lib/filepaste", ["base", "mediator", "runtime/client"],
    function(a, b, c) {
        function d(a) {
            a = this.options = e.extend({},
            a),
            a.container = e(a.container || document.body),
            c.call(this, "FilePaste")
        }
        var e = a.$;
        return a.inherits(c, {
            constructor: d,
            init: function() {
                var a = this;
                a.connectRuntime(a.options,
                function() {
                    a.exec("init"),
                    a.trigger("ready")
                })
            },
            destroy: function() {
                this.exec("destroy"),
                this.disconnectRuntime(),
                this.off()
            }
        }),
        b.installTo(d.prototype),
        d
    }),
    b("widgets/filepaste", ["base", "uploader", "lib/filepaste", "widgets/widget"],
    function(a, b, c) {
        var d = a.$;
        return b.register({
            init: function(b) {
                if (b.paste && "html5" === this.request("predict-runtime-type")) {
                    var e, f = this,
                    g = a.Deferred(),
                    h = d.extend({},
                    {
                        container: b.paste,
                        accept: b.accept
                    });
                    return e = new c(h),
                    e.once("ready", g.resolve),
                    e.on("paste",
                    function(a) {
                        f.owner.request("add-file", [a])
                    }),
                    e.init(),
                    g.promise()
                }
            }
        })
    }),
    b("lib/blob", ["base", "runtime/client"],
    function(a, b) {
        function c(a, c) {
            var d = this;
            d.source = c,
            d.ruid = a,
            b.call(d, "Blob"),
            this.uid = c.uid || this.uid,
            this.type = c.type || "",
            this.size = c.size || 0,
            a && d.connectRuntime(a)
        }
        return a.inherits(b, {
            constructor: c,
            slice: function(a, b) {
                return this.exec("slice", a, b)
            },
            getSource: function() {
                return this.source
            }
        }),
        c
    }),
    b("lib/file", ["base", "lib/blob"],
    function(a, b) {
        function c(a, c) {
            var f;
            b.apply(this, arguments),
            this.name = c.name || "untitled" + d++,
            f = e.exec(c.name) ? RegExp.$1.toLowerCase() : "",
            !f && this.type && (f = /\/(jpg|jpeg|png|gif|bmp)$/i.exec(this.type) ? RegExp.$1.toLowerCase() : "", this.name += "." + f),
            !this.type && ~"jpg,jpeg,png,gif,bmp".indexOf(f) && (this.type = "image/" + ("jpg" === f ? "jpeg": f)),
            this.ext = f,
            this.lastModifiedDate = c.lastModifiedDate || (new Date).toLocaleString()
        }
        var d = 1,
        e = /\.([^.]+)$/;
        return a.inherits(b, c)
    }),
    b("lib/filepicker", ["base", "runtime/client", "lib/file"],
    function(b, c, d) {
        function e(a) {
            if (a = this.options = f.extend({},
            e.options, a), a.container = f(a.id), !a.container.length) throw new Error("按钮指定错误");
            a.label = a.label || a.container.html() || " ",
            a.button = f(a.button || document.createElement("div")),
            a.button.html(a.label),
            a.container.html(a.button),
            c.call(this, "FilePicker", !0)
        }
        var f = b.$;
        return e.options = {
            button: null,
            container: null,
            label: null,
            multiple: !0,
            accept: null,
            name: "file"
        },
        b.inherits(c, {
            constructor: e,
            init: function() {
                var b = this,
                c = b.options,
                e = c.button;
                e.addClass("webuploader-pick"),
                b.on("all",
                function(a) {
                    var c;
                    switch (a) {
                    case "mouseenter":
                        e.addClass("webuploader-pick-hover");
                        break;
                    case "mouseleave":
                        e.removeClass("webuploader-pick-hover");
                        break;
                    case "change":
                        c = b.exec("getFiles"),
                        b.trigger("select", f.map(c,
                        function(a) {
                            return new d(b.getRuid(), a)
                        }))
                    }
                }),
                b.connectRuntime(c,
                function() {
                    b.refresh(),
                    b.exec("init", c),
                    b.trigger("ready")
                }),
                f(a).on("resize",
                function() {
                    b.refresh()
                })
            },
            refresh: function() {
                var a = this.getRuntime().getContainer(),
                b = this.options.button,
                c = b.outerWidth ? b.outerWidth() : b.width(),
                d = b.outerHeight ? b.outerHeight() : b.height(),
                e = b.offset();
                c && d && a.css({
                    bottom: "auto",
                    right: "auto",
                    width: c + "px",
                    height: d + "px"
                }).offset(e)
            },
            enable: function() {
                var a = this.options.button;
                a.removeClass("webuploader-pick-disable"),
                this.refresh()
            },
            disable: function() {
                var a = this.options.button;
                this.getRuntime().getContainer().css({
                    top: "-99999px"
                }),
                a.addClass("webuploader-pick-disable")
            },
            destroy: function() {
                this.runtime && (this.exec("destroy"), this.disconnectRuntime())
            }
        }),
        e
    }),
    b("widgets/filepicker", ["base", "uploader", "lib/filepicker", "widgets/widget"],
    function(a, b, c) {
        var d = a.$;
        return d.extend(b.options, {
            pick: null,
            accept: null
        }),
        b.register({
            "add-btn": "addButton",
            refresh: "refresh",
            disable: "disable",
            enable: "enable"
        },
        {
            init: function(a) {
                return this.pickers = [],
                a.pick && this.addButton(a.pick)
            },
            refresh: function() {
                d.each(this.pickers,
                function() {
                    this.refresh()
                })
            },
            addButton: function(b) {
                var e, f, g, h = this,
                i = h.options,
                j = i.accept;
                if (b) return g = a.Deferred(),
                d.isPlainObject(b) || (b = {
                    id: b
                }),
                e = d.extend({},
                b, {
                    accept: d.isPlainObject(j) ? [j] : j,
                    swf: i.swf,
                    runtimeOrder: i.runtimeOrder
                }),
                f = new c(e),
                f.once("ready", g.resolve),
                f.on("select",
                function(a) {
                    h.owner.request("add-file", [a])
                }),
                f.init(),
                this.pickers.push(f),
                g.promise()
            },
            disable: function() {
                d.each(this.pickers,
                function() {
                    this.disable()
                })
            },
            enable: function() {
                d.each(this.pickers,
                function() {
                    this.enable()
                })
            }
        })
    }),
    b("lib/image", ["base", "runtime/client", "lib/blob"],
    function(a, b, c) {
        function d(a) {
            this.options = e.extend({},
            d.options, a),
            b.call(this, "Image"),
            this.on("load",
            function() {
                this._info = this.exec("info"),
                this._meta = this.exec("meta")
            })
        }
        var e = a.$;
        return d.options = {
            quality: 90,
            crop: !1,
            preserveHeaders: !0,
            allowMagnify: !0
        },
        a.inherits(b, {
            constructor: d,
            info: function(a) {
                return a ? (this._info = a, this) : this._info
            },
            meta: function(a) {
                return a ? (this._meta = a, this) : this._meta
            },
            loadFromBlob: function(a) {
                var b = this,
                c = a.getRuid();
                this.connectRuntime(c,
                function() {
                    b.exec("init", b.options),
                    b.exec("loadFromBlob", a)
                })
            },
            resize: function() {
                var b = a.slice(arguments);
                return this.exec.apply(this, ["resize"].concat(b))
            },
            getAsDataUrl: function(a) {
                return this.exec("getAsDataUrl", a)
            },
            getAsBlob: function(a) {
                var b = this.exec("getAsBlob", a);
                return new c(this.getRuid(), b)
            }
        }),
        d
    }),
    b("widgets/image", ["base", "uploader", "lib/image", "widgets/widget"],
    function(a, b, c) {
        var d, e = a.$;
        return d = function(a) {
            var b = 0,
            c = [],
            d = function() {
                for (var d; c.length && a > b;) d = c.shift(),
                b += d[0],
                d[1]()
            };
            return function(a, e, f) {
                c.push([e, f]),
                a.once("destroy",
                function() {
                    b -= e,
                    setTimeout(d, 1)
                }),
                setTimeout(d, 1)
            }
        } (5242880),
        e.extend(b.options, {
            thumb: {
                width: 110,
                height: 110,
                quality: 70,
                allowMagnify: !0,
                crop: !0,
                preserveHeaders: !1,
                type: "image/jpeg"
            },
            compress: {
                width: 1600,
                height: 1600,
                quality: 90,
                allowMagnify: !1,
                crop: !1,
                preserveHeaders: !0
            }
        }),
        b.register({
            "make-thumb": "makeThumb",
            "before-send-file": "compressImage"
        },
        {
            makeThumb: function(a, b, f, g) {
                var h, i;
                return a = this.request("get-file", a),
                a.type.match(/^image/) ? (h = e.extend({},
                this.options.thumb), e.isPlainObject(f) && (h = e.extend(h, f), f = null), f = f || h.width, g = g || h.height, i = new c(h), i.once("load",
                function() {
                    a._info = a._info || i.info(),
                    a._meta = a._meta || i.meta(),
                    i.resize(f, g)
                }), i.once("complete",
                function() {
                    b(!1, i.getAsDataUrl(h.type)),
                    i.destroy()
                }), i.once("error",
                function() {
                    b(!0),
                    i.destroy()
                }), void d(i, a.source.size,
                function() {
                    a._info && i.info(a._info),
                    a._meta && i.meta(a._meta),
                    i.loadFromBlob(a.source)
                })) : void b(!0)
            },
            compressImage: function(b) {
                var d, f, g = this.options.compress || this.options.resize,
                h = g && g.compressSize || 307200;
                return b = this.request("get-file", b),
                !g || !~"image/jpeg,image/jpg".indexOf(b.type) || b.size < h || b._compressed ? void 0 : (g = e.extend({},
                g), f = a.Deferred(), d = new c(g), f.always(function() {
                    d.destroy(),
                    d = null
                }), d.once("error", f.reject), d.once("load",
                function() {
                    b._info = b._info || d.info(),
                    b._meta = b._meta || d.meta(),
                    d.resize(g.width, g.height)
                }), d.once("complete",
                function() {
                    var a, c;
                    try {
                        a = d.getAsBlob(g.type),
                        c = b.size,
                        a.size < c && (b.source = a, b.size = a.size, b.trigger("resize", a.size, c)),
                        b._compressed = !0,
                        f.resolve()
                    } catch(e) {
                        f.resolve()
                    }
                }), b._info && d.info(b._info), b._meta && d.meta(b._meta), d.loadFromBlob(b.source), f.promise())
            }
        })
    }),
    b("file", ["base", "mediator"],
    function(a, b) {
        function c() {
            return f + g++
        }
        function d(a) {
            this.name = a.name || "Untitled",
            this.size = a.size || 0,
            this.type = a.type || "application",
            this.lastModifiedDate = a.lastModifiedDate || 1 * new Date,
            this.id = c(),
            this.ext = h.exec(this.name) ? RegExp.$1: "",
            this.statusText = "",
            i[this.id] = d.Status.INITED,
            this.source = a,
            this.loaded = 0,
            this.on("error",
            function(a) {
                this.setStatus(d.Status.ERROR, a)
            })
        }
        var e = a.$,
        f = "WU_FILE_",
        g = 0,
        h = /\.([^.]+)$/,
        i = {};
        return e.extend(d.prototype, {
            setStatus: function(a, b) {
                var c = i[this.id];
                "undefined" != typeof b && (this.statusText = b),
                a !== c && (i[this.id] = a, this.trigger("statuschange", a, c))
            },
            getStatus: function() {
                return i[this.id]
            },
            getSource: function() {
                return this.source
            },
            destory: function() {
                delete i[this.id]
            }
        }),
        b.installTo(d.prototype),
        d.Status = {
            INITED: "inited",
            QUEUED: "queued",
            PROGRESS: "progress",
            ERROR: "error",
            COMPLETE: "complete",
            CANCELLED: "cancelled",
            INTERRUPT: "interrupt",
            INVALID: "invalid"
        },
        d
    }),
    b("queue", ["base", "mediator", "file"],
    function(a, b, c) {
        function d() {
            this.stats = {
                numOfQueue: 0,
                numOfSuccess: 0,
                numOfCancel: 0,
                numOfProgress: 0,
                numOfUploadFailed: 0,
                numOfInvalid: 0
            },
            this._queue = [],
            this._map = {}
        }
        var e = a.$,
        f = c.Status;
        return e.extend(d.prototype, {
            append: function(a) {
                return this._queue.push(a),
                this._fileAdded(a),
                this
            },
            prepend: function(a) {
                return this._queue.unshift(a),
                this._fileAdded(a),
                this
            },
            getFile: function(a) {
                return "string" != typeof a ? a: this._map[a]
            },
            fetch: function(a) {
                var b, c, d = this._queue.length;
                for (a = a || f.QUEUED, b = 0; d > b; b++) if (c = this._queue[b], a === c.getStatus()) return c;
                return null
            },
            sort: function(a) {
                "function" == typeof a && this._queue.sort(a)
            },
            getFiles: function() {
                for (var a, b = [].slice.call(arguments, 0), c = [], d = 0, f = this._queue.length; f > d; d++) a = this._queue[d],
                (!b.length || ~e.inArray(a.getStatus(), b)) && c.push(a);
                return c
            },
            _fileAdded: function(a) {
                var b = this,
                c = this._map[a.id];
                c || (this._map[a.id] = a, a.on("statuschange",
                function(a, c) {
                    b._onFileStatusChange(a, c)
                })),
                a.setStatus(f.QUEUED)
            },
            _onFileStatusChange: function(a, b) {
                var c = this.stats;
                switch (b) {
                case f.PROGRESS:
                    c.numOfProgress--;
                    break;
                case f.QUEUED:
                    c.numOfQueue--;
                    break;
                case f.ERROR:
                    c.numOfUploadFailed--;
                    break;
                case f.INVALID:
                    c.numOfInvalid--
                }
                switch (a) {
                case f.QUEUED:
                    c.numOfQueue++;
                    break;
                case f.PROGRESS:
                    c.numOfProgress++;
                    break;
                case f.ERROR:
                    c.numOfUploadFailed++;
                    break;
                case f.COMPLETE:
                    c.numOfSuccess++;
                    break;
                case f.CANCELLED:
                    c.numOfCancel++;
                    break;
                case f.INVALID:
                    c.numOfInvalid++
                }
            }
        }),
        b.installTo(d.prototype),
        d
    }),
    b("widgets/queue", ["base", "uploader", "queue", "file", "lib/file", "runtime/client", "widgets/widget"],
    function(a, b, c, d, e, f) {
        var g = a.$,
        h = /\.\w+$/,
        i = d.Status;
        return b.register({
            "sort-files": "sortFiles",
            "add-file": "addFiles",
            "get-file": "getFile",
            "fetch-file": "fetchFile",
            "get-stats": "getStats",
            "get-files": "getFiles",
            "remove-file": "removeFile",
            retry: "retry",
            reset: "reset"
        },
        {
            init: function(b) {
                var d, e, h, i, j, k, l, m = this;
                if (g.isPlainObject(b.accept) && (b.accept = [b.accept]), b.accept) {
                    for (j = [], h = 0, e = b.accept.length; e > h; h++) i = b.accept[h].extensions,
                    i && j.push(i);
                    j.length && (k = "\\." + j.join(",").replace(/,/g, "$|\\.").replace(/\*/g, ".*") + "$"),
                    m.accept = new RegExp(k, "i")
                }
                return m.queue = new c,
                m.stats = m.queue.stats,
                "html5" === this.request("predict-runtime-type") ? (d = a.Deferred(), l = new f("Placeholder"), l.connectRuntime({
                    runtimeOrder: "html5"
                },
                function() {
                    m._ruid = l.getRuid(),
                    d.resolve()
                }), d.promise()) : void 0
            },
            _wrapFile: function(a) {
                if (! (a instanceof d)) {
                    if (! (a instanceof e)) {
                        if (!this._ruid) throw new Error("Can't add external files.");
                        a = new e(this._ruid, a)
                    }
                    a = new d(a)
                }
                return a
            },
            _addFile: function(a) {
                var b = this;
                if (! (!a || a.size < 6 || b.accept && h.exec(a.name) && !b.accept.test(a.name)) && (a = b._wrapFile(a), b.owner.trigger("beforeFileQueued", a))) return b.queue.append(a),
                b.owner.trigger("fileQueued", a),
                a
            },
            getFile: function(a) {
                return this.queue.getFile(a)
            },
            addFiles: function(a) {
                var b = this;
                a.length || (a = [a]),
                a = g.map(a,
                function(a) {
                    return b._addFile(a)
                }),
                b.owner.trigger("filesQueued", a),
                b.options.auto && b.request("start-upload")
            },
            getStats: function() {
                return this.stats
            },
            removeFile: function(a) {
                var b = this;
                a = a.id ? a: b.queue.getFile(a),
                a.setStatus(i.CANCELLED),
                b.owner.trigger("fileDequeued", a)
            },
            getFiles: function() {
                return this.queue.getFiles.apply(this.queue, arguments)
            },
            fetchFile: function() {
                return this.queue.fetch.apply(this.queue, arguments)
            },
            retry: function(a, b) {
                var c, d, e, f = this;
                if (a) return a = a.id ? a: f.queue.getFile(a),
                a.setStatus(i.QUEUED),
                void(b || f.request("start-upload"));
                for (c = f.queue.getFiles(i.ERROR), d = 0, e = c.length; e > d; d++) a = c[d],
                a.setStatus(i.QUEUED);
                f.request("start-upload")
            },
            sortFiles: function() {
                return this.queue.sort.apply(this.queue, arguments)
            },
            reset: function() {
                this.queue = new c,
                this.stats = this.queue.stats
            }
        })
    }),
    b("widgets/runtime", ["uploader", "runtime/runtime", "widgets/widget"],
    function(a, b) {
        return a.support = function() {
            return b.hasRuntime.apply(b, arguments)
        },
        a.register({
            "predict-runtime-type": "predictRuntmeType"
        },
        {
            init: function() {
                if (!this.predictRuntmeType()) throw Error("Runtime Error")
            },
            predictRuntmeType: function() {
                var a, c, d = this.options.runtimeOrder || b.orders,
                e = this.type;
                if (!e) for (d = d.split(/\s*,\s*/g), a = 0, c = d.length; c > a; a++) if (b.hasRuntime(d[a])) {
                    this.type = e = d[a];
                    break
                }
                return e
            }
        })
    }),
    b("lib/transport", ["base", "runtime/client", "mediator"],
    function(a, b, c) {
        function d(a) {
            var c = this;
            a = c.options = e.extend(!0, {},
            d.options, a || {}),
            b.call(this, "Transport"),
            this._blob = null,
            this._formData = a.formData || {},
            this._headers = a.headers || {},
            this.on("progress", this._timeout),
            this.on("load error",
            function() {
                c.trigger("progress", 1),
                clearTimeout(c._timer)
            })
        }
        var e = a.$;
        return d.options = {
            server: "",
            method: "POST",
            withCredentials: !1,
            fileVal: "file",
            timeout: 12e4,
            formData: {},
            headers: {},
            sendAsBinary: !1
        },
        e.extend(d.prototype, {
            appendBlob: function(a, b, c) {
                var d = this,
                e = d.options;
                d.getRuid() && d.disconnectRuntime(),
                d.connectRuntime(b.ruid,
                function() {
                    d.exec("init")
                }),
                d._blob = b,
                e.fileVal = a || e.fileVal,
                e.filename = c || e.filename
            },
            append: function(a, b) {
                "object" == typeof a ? e.extend(this._formData, a) : this._formData[a] = b
            },
            setRequestHeader: function(a, b) {
                "object" == typeof a ? e.extend(this._headers, a) : this._headers[a] = b
            },
            send: function(a) {
                this.exec("send", a),
                this._timeout()
            },
            abort: function() {
                return clearTimeout(this._timer),
                this.exec("abort")
            },
            destroy: function() {
                this.trigger("destroy"),
                this.off(),
                this.exec("destroy"),
                this.disconnectRuntime()
            },
            getResponse: function() {
                return this.exec("getResponse")
            },
            getResponseAsJson: function() {
                return this.exec("getResponseAsJson")
            },
            getStatus: function() {
                return this.exec("getStatus")
            },
            _timeout: function() {
                var a = this,
                b = a.options.timeout;
                b && (clearTimeout(a._timer), a._timer = setTimeout(function() {
                    a.abort(),
                    a.trigger("error", "timeout")
                },
                b))
            }
        }),
        c.installTo(d.prototype),
        d
    }),
    b("widgets/upload", ["base", "uploader", "file", "lib/transport", "widgets/widget"],
    function(a, b, c, d) {
        function e(a, b) {
            for (var c, d = [], e = a.source, f = e.size, g = b ? Math.ceil(f / b) : 1, h = 0, i = 0; g > i;) c = Math.min(b, f - h),
            d.push({
                file: a,
                start: h,
                end: b ? h + c: f,
                total: f,
                chunks: g,
                chunk: i++
            }),
            h += c;
            return a.blocks = d.concat(),
            a.remaning = d.length,
            {
                file: a,
                has: function() {
                    return !! d.length
                },
                fetch: function() {
                    return d.shift()
                }
            }
        }
        var f = a.$,
        g = a.isPromise,
        h = c.Status;
        f.extend(b.options, {
            prepareNextFile: !1,
            chunked: !1,
            chunkSize: 5242880,
            chunkRetry: 2,
            threads: 3,
            formData: null
        }),
        b.register({
            "start-upload": "start",
            "stop-upload": "stop",
            "skip-file": "skipFile",
            "is-in-progress": "isInProgress"
        },
        {
            init: function() {
                var b = this.owner;
                this.runing = !1,
                this.pool = [],
                this.pending = [],
                this.remaning = 0,
                this.__tick = a.bindFn(this._tick, this),
                b.on("uploadComplete",
                function(a) {
                    a.blocks && f.each(a.blocks,
                    function(a, b) {
                        b.transport && (b.transport.abort(), b.transport.destroy()),
                        delete b.transport
                    }),
                    delete a.blocks,
                    delete a.remaning
                })
            },
            start: function() {
                var b = this;
                f.each(b.request("get-files", h.INVALID),
                function() {
                    b.request("remove-file", this)
                }),
                b.runing || (b.runing = !0, f.each(b.pool,
                function(a, c) {
                    var d = c.file;
                    d.getStatus() === h.INTERRUPT && (d.setStatus(h.PROGRESS), b._trigged = !1, c.transport && c.transport.send())
                }), b._trigged = !1, b.owner.trigger("startUpload"), a.nextTick(b.__tick))
            },
            stop: function(a) {
                var b = this;
                b.runing !== !1 && (b.runing = !1, a && f.each(b.pool,
                function(a, b) {
                    b.transport && b.transport.abort(),
                    b.file.setStatus(h.INTERRUPT)
                }), b.owner.trigger("stopUpload"))
            },
            isInProgress: function() {
                return !! this.runing
            },
            getStats: function() {
                return this.request("get-stats")
            },
            skipFile: function(a, b) {
                a = this.request("get-file", a),
                a.setStatus(b || h.COMPLETE),
                a.skipped = !0,
                a.blocks && f.each(a.blocks,
                function(a, b) {
                    var c = b.transport;
                    c && (c.abort(), c.destroy(), delete b.transport)
                }),
                this.owner.trigger("uploadSkip", a)
            },
            _tick: function() {
                var b, c, d = this,
                e = d.options;
                return d._promise ? d._promise.always(d.__tick) : void(d.pool.length < e.threads && (c = d._nextBlock()) ? (d._trigged = !1, b = function(b) {
                    d._promise = null,
                    b && b.file && d._startSend(b),
                    a.nextTick(d.__tick)
                },
                d._promise = g(c) ? c.always(b) : b(c)) : d.remaning || d.getStats().numOfQueue || (d.runing = !1, d._trigged || a.nextTick(function() {
                    d.owner.trigger("uploadFinished")
                }), d._trigged = !0))
            },
            _nextBlock: function() {
                var a, b, c = this,
                d = c._act,
                f = c.options;
                return d && d.has() && d.file.getStatus() === h.PROGRESS ? (f.prepareNextFile && !c.pending.length && c._prepareNextFile(), d.fetch()) : c.runing ? (!c.pending.length && c.getStats().numOfQueue && c._prepareNextFile(), a = c.pending.shift(), b = function(a) {
                    return a ? (d = e(a, f.chunked ? f.chunkSize: 0), c._act = d, d.fetch()) : null
                },
                g(a) ? a.pipe(b) : b(a)) : void 0
            },
            _prepareNextFile: function() {
                var a, b = this,
                c = b.request("fetch-file"),
                d = b.pending;
                c && (a = b.request("before-send-file", c,
                function() {
                    return c.getStatus() === h.QUEUED ? (b.owner.trigger("uploadStart", c), c.setStatus(h.PROGRESS), c) : b._finishFile(c)
                }), a.done(function() {
                    var b = f.inArray(a, d);~b && d.splice(b, 1, c)
                }), a.fail(function(a) {
                    c.setStatus(h.ERROR, a),
                    b.owner.trigger("uploadError", c, a),
                    b.owner.trigger("uploadComplete", c)
                }), d.push(a))
            },
            _popBlock: function(a) {
                var b = f.inArray(a, this.pool);
                this.pool.splice(b, 1),
                a.file.remaning--,
                this.remaning--
            },
            _startSend: function(b) {
                var c, d = this,
                e = b.file;
                d.pool.push(b),
                d.remaning++,
                b.blob = 1 === b.chunks ? e.source: e.source.slice(b.start, b.end),
                c = d.request("before-send", b,
                function() {
                    e.getStatus() === h.PROGRESS ? d._doSend(b) : (d._popBlock(b), a.nextTick(d.__tick))
                }),
                c.fail(function() {
                    1 === e.remaning ? d._finishFile(e).always(function() {
                        b.percentage = 1,
                        d._popBlock(b),
                        d.owner.trigger("uploadComplete", e),
                        a.nextTick(d.__tick)
                    }) : (b.percentage = 1, d._popBlock(b), a.nextTick(d.__tick))
                })
            },
            _doSend: function(b) {
                var c, e, g = this,
                i = g.owner,
                j = g.options,
                k = b.file,
                l = new d(j),
                m = f.extend({},
                j.formData),
                n = f.extend({},
                j.headers);
                b.transport = l,
                l.on("destroy",
                function() {
                    delete b.transport,
                    g._popBlock(b),
                    a.nextTick(g.__tick)
                }),
                l.on("progress",
                function(a) {
                    var c = 0,
                    d = 0;
                    c = b.percentage = a,
                    b.chunks > 1 && (f.each(k.blocks,
                    function(a, b) {
                        d += (b.percentage || 0) * (b.end - b.start)
                    }), c = d / k.size),
                    i.trigger("uploadProgress", k, c || 0)
                }),
                c = function(a) {
                    var c;
                    return e = l.getResponseAsJson() || {},
                    e._raw = l.getResponse(),
                    c = function(b) {
                        a = b
                    },
                    i.trigger("uploadAccept", b, e, c) || (a = a || "server"),
                    a
                },
                l.on("error",
                function(a, d) {
                    b.retried = b.retried || 0,
                    b.chunks > 1 && ~"http,abort".indexOf(a) && b.retried < j.chunkRetry ? (b.retried++, l.send()) : (d || "server" !== a || (a = c(a)), k.setStatus(h.ERROR, a), i.trigger("uploadError", k, a), i.trigger("uploadComplete", k))
                }),
                l.on("load",
                function() {
                    var a;
                    return (a = c()) ? void l.trigger("error", a, !0) : void(1 === k.remaning ? g._finishFile(k, e) : l.destroy())
                }),
                m = f.extend(m, {
                    id: k.id,
                    name: k.name,
                    type: k.type,
                    lastModifiedDate: k.lastModifiedDate,
                    size: k.size
                }),
                b.chunks > 1 && f.extend(m, {
                    chunks: b.chunks,
                    chunk: b.chunk
                }),
                i.trigger("uploadBeforeSend", b, m, n),
                l.appendBlob(j.fileVal, b.blob, k.name),
                l.append(m),
                l.setRequestHeader(n),
                l.send()
            },
            _finishFile: function(a, b, c) {
                var d = this.owner;
                return d.request("after-send-file", arguments,
                function() {
                    a.setStatus(h.COMPLETE),
                    d.trigger("uploadSuccess", a, b, c)
                }).fail(function(b) {
                    a.getStatus() === h.PROGRESS && a.setStatus(h.ERROR, b),
                    d.trigger("uploadError", a, b)
                }).always(function() {
                    d.trigger("uploadComplete", a)
                })
            }
        })
    }),
    b("widgets/validator", ["base", "uploader", "file", "widgets/widget"],
    function(a, b, c) {
        var d, e = a.$,
        f = {};
        return d = {
            addValidator: function(a, b) {
                f[a] = b
            },
            removeValidator: function(a) {
                delete f[a]
            }
        },
        b.register({
            init: function() {
                var a = this;
                e.each(f,
                function() {
                    this.call(a.owner)
                })
            }
        }),
        d.addValidator("fileNumLimit",
        function() {
            var a = this,
            b = a.options,
            c = 0,
            d = b.fileNumLimit >> 0,
            e = !0;
            d && (a.on("beforeFileQueued",
            function() {
                return c >= d && e && (e = !1, this.trigger("error", "Q_EXCEED_NUM_LIMIT", d), setTimeout(function() {
                    e = !0
                },
                1)),
                c >= d ? !1 : !0
            }), a.on("fileQueued",
            function() {
                c++
            }), a.on("fileDequeued",
            function() {
                c--
            }), a.on("uploadFinished",
            function() {
                c = 0
            }))
        }),
        d.addValidator("fileSizeLimit",
        function() {
            var a = this,
            b = a.options,
            c = 0,
            d = b.fileSizeLimit >> 0,
            e = !0;
            d && (a.on("beforeFileQueued",
            function(a) {
                var b = c + a.size > d;
                return b && e && (e = !1, this.trigger("error", "Q_EXCEED_SIZE_LIMIT", d), setTimeout(function() {
                    e = !0
                },
                1)),
                b ? !1 : !0
            }), a.on("fileQueued",
            function(a) {
                c += a.size
            }), a.on("fileDequeued",
            function(a) {
                c -= a.size
            }), a.on("uploadFinished",
            function() {
                c = 0
            }))
        }),
        d.addValidator("fileSingleSizeLimit",
        function() {
            var a = this,
            b = a.options,
            d = b.fileSingleSizeLimit;
            d && a.on("beforeFileQueued",
            function(a) {
                return a.size > d ? (a.setStatus(c.Status.INVALID, "exceed_size"), this.trigger("error", "F_EXCEED_SIZE"), !1) : void 0
            })
        }),
        d.addValidator("duplicate",
        function() {
            function a(a) {
                for (var b, c = 0,
                d = 0,
                e = a.length; e > d; d++) b = a.charCodeAt(d),
                c = b + (c << 6) + (c << 16) - c;
                return c
            }
            var b = this,
            c = b.options,
            d = {};
            c.duplicate || (b.on("beforeFileQueued",
            function(b) {
                var c = b.__hash || (b.__hash = a(b.name + b.size + b.lastModifiedDate));
                return d[c] ? (this.trigger("error", "F_DUPLICATE"), !1) : void 0
            }), b.on("fileQueued",
            function(a) {
                var b = a.__hash;
                b && (d[b] = !0)
            }), b.on("fileDequeued",
            function(a) {
                var b = a.__hash;
                b && delete d[b]
            }))
        }),
        d
    }),
    b("runtime/compbase", [],
    function() {
        function a(a, b) {
            this.owner = a,
            this.options = a.options,
            this.getRuntime = function() {
                return b
            },
            this.getRuid = function() {
                return b.uid
            },
            this.trigger = function() {
                return a.trigger.apply(a, arguments)
            }
        }
        return a
    }),
    b("runtime/html5/runtime", ["base", "runtime/runtime", "runtime/compbase"],
    function(b, c, d) {
        function e() {
            var a = {},
            d = this,
            e = this.destory;
            c.apply(d, arguments),
            d.type = f,
            d.exec = function(c, e) {
                var f, h = this,
                i = h.uid,
                j = b.slice(arguments, 2);
                return g[c] && (f = a[i] = a[i] || new g[c](h, d), f[e]) ? f[e].apply(f, j) : void 0
            },
            d.destory = function() {
                return e && e.apply(this, arguments)
            }
        }
        var f = "html5",
        g = {};
        return b.inherits(c, {
            constructor: e,
            init: function() {
                var a = this;
                setTimeout(function() {
                    a.trigger("ready")
                },
                1)
            }
        }),
        e.register = function(a, c) {
            var e = g[a] = b.inherits(d, c);
            return e
        },
        a.Blob && a.FileReader && a.DataView && c.addRuntime(f, e),
        e
    }),
    b("runtime/html5/blob", ["runtime/html5/runtime", "lib/blob"],
    function(a, b) {
        return a.register("Blob", {
            slice: function(a, c) {
                var d = this.owner.source,
                e = d.slice || d.webkitSlice || d.mozSlice;
                return d = e.call(d, a, c),
                new b(this.getRuid(), d)
            }
        })
    }),
    b("runtime/html5/dnd", ["base", "runtime/html5/runtime", "lib/file"],
    function(a, b, c) {
        var d = a.$;
        return b.register("DragAndDrop", {
            init: function() {
                var b = this.elem = this.options.container;
                this.dragEnterHandler = a.bindFn(this._dragEnterHandler, this),
                this.dragOverHandler = a.bindFn(this._dragOverHandler, this),
                this.dragLeaveHandler = a.bindFn(this._dragLeaveHandler, this),
                this.dropHandler = a.bindFn(this._dropHandler, this),
                this.dndOver = !1,
                b.on("dragenter", this.dragEnterHandler),
                b.on("dragover", this.dragOverHandler),
                b.on("dragleave", this.dragLeaveHandler),
                b.on("drop", this.dropHandler),
                this.options.disableGlobalDnd && (d(document).on("dragover", this.dragOverHandler), d(document).on("drop", this.dropHandler))
            },
            _dragEnterHandler: function(a) {
                return this.dndOver = !0,
                this.elem.addClass("webuploader-dnd-over"),
                a = a.originalEvent || a,
                a.dataTransfer.dropEffect = "copy",
                !1
            },
            _dragOverHandler: function(a) {
                var b = this.elem.parent().get(0);
                return b && !d.contains(b, a.target) ? !1 : (this._dragEnterHandler.call(this, a), !1)
            },
            _dragLeaveHandler: function() {
                var a = this,
                b = function() {
                    a.dndOver || a.elem.removeClass("webuploader-dnd-over")
                };
                return setTimeout(b, 50),
                this.dndOver = !1,
                !1
            },
            _dropHandler: function(b) {
                var e, f, g, h, i, j, k, l, m = [],
                n = [],
                o = this,
                p = o.getRuid(),
                q = o.elem.parent().get(0);
                if (q && !d.contains(q, b.currentTarget)) return ! 1;
                for (b = b.originalEvent || b, g = b.dataTransfer, e = g.items, f = g.files, l = !(!e || !e[0].webkitGetAsEntry), j = 0, k = f.length; k > j; j++) h = f[j],
                i = e && e[j],
                l && i.webkitGetAsEntry().isDirectory ? n.push(this._traverseDirectoryTree(i.webkitGetAsEntry(), m)) : m.push(h);
                return a.when.apply(a, n).done(function() {
                    m.length && o.trigger("drop", d.map(m,
                    function(a) {
                        return new c(p, a)
                    }))
                }),
                this.dndOver = !1,
                this.elem.removeClass("webuploader-dnd-over"),
                !1
            },
            _traverseDirectoryTree: function(b, c) {
                var d = a.Deferred(),
                e = this;
                return b.isFile ? b.file(function(a) {
                    c.push(a),
                    d.resolve()
                }) : b.isDirectory && b.createReader().readEntries(function(b) {
                    var f, g = b.length,
                    h = [],
                    i = [];
                    for (f = 0; g > f; f++) h.push(e._traverseDirectoryTree(b[f], i));
                    a.when.apply(a, h).then(function() {
                        c.push.apply(c, i),
                        d.resolve()
                    },
                    d.reject)
                }),
                d.promise()
            },
            destroy: function() {
                var a = this.elem;
                a.off("dragenter", this.dragEnterHandler),
                a.off("dragover", this.dragEnterHandler),
                a.off("dragleave", this.dragLeaveHandler),
                a.off("drop", this.dropHandler),
                this.options.disableGlobalDnd && (d(document).off("dragover", this.dragOverHandler), d(document).off("drop", this.dropHandler))
            }
        })
    }),
    b("runtime/html5/filepaste", ["base", "runtime/html5/runtime", "lib/file"],
    function(a, b, c) {
        return b.register("FilePaste", {
            init: function() {
                var b, c, d, e, f = this.options,
                g = this.elem = f.container,
                h = ".*";
                if (f.accept) {
                    for (b = [], c = 0, d = f.accept.length; d > c; c++) e = f.accept[c].mimeTypes,
                    e && b.push(e);
                    b.length && (h = b.join(","), h = h.replace(/,/g, "|").replace(/\*/g, ".*"))
                }
                this.accept = h = new RegExp(h, "i"),
                this.hander = a.bindFn(this._pasteHander, this),
                g.on("paste", this.hander)
            },
            _pasteHander: function(a) {
                var b, d, e, f, g, h = [],
                i = this.getRuid();
                for (a = a.originalEvent || a, b = a.clipboardData.items, f = 0, g = b.length; g > f; f++) d = b[f],
                "file" === d.kind && (e = d.getAsFile()) && h.push(new c(i, e));
                h.length && (a.preventDefault(), a.stopPropagation(), this.trigger("paste", h))
            },
            destroy: function() {
                this.elem.off("paste", this.hander)
            }
        })
    }),
    b("runtime/html5/filepicker", ["base", "runtime/html5/runtime"],
    function(a, b) {
        var c = a.$;
        return b.register("FilePicker", {
            init: function() {
                var a, b, d, e, f = this.getRuntime().getContainer(),
                g = this,
                h = g.owner,
                i = g.options,
                j = c(document.createElement("label")),
                k = c(document.createElement("input"));
                if (k.attr("type", "file"), k.attr("name", i.name), k.addClass("webuploader-element-invisible"), j.on("click",
                function() {
                    k.trigger("click")
                }), j.css({
                    opacity: 0,
                    width: "100%",
                    height: "100%",
                    display: "block",
                    cursor: "pointer",
                    background: "#ffffff"
                }), i.multiple && k.attr("multiple", "multiple"), i.accept && i.accept.length > 0) {
                    for (a = [], b = 0, d = i.accept.length; d > b; b++) a.push(i.accept[b].mimeTypes);
                    k.attr("accept", a.join(","))
                }
                f.append(k),
                f.append(j),
                e = function(a) {
                    h.trigger(a.type)
                },
                k.on("change",
                function(a) {
                    var b, d = arguments.callee;
                    g.files = a.target.files,
                    b = this.cloneNode(!0),
                    this.parentNode.replaceChild(b, this),
                    k.off(),
                    k = c(b).on("change", d).on("mouseenter mouseleave", e),
                    h.trigger("change")
                }),
                j.on("mouseenter mouseleave", e)
            },
            getFiles: function() {
                return this.files
            },
            destroy: function() {}
        })
    }),
    b("runtime/html5/util", ["base"],
    function(b) {
        var c = a.createObjectURL && a || a.URL && URL.revokeObjectURL && URL || a.webkitURL,
        d = b.noop,
        e = d;
        return c && (d = function() {
            return c.createObjectURL.apply(c, arguments)
        },
        e = function() {
            return c.revokeObjectURL.apply(c, arguments)
        }),
        {
            createObjectURL: d,
            revokeObjectURL: e,
            dataURL2Blob: function(a) {
                var b, c, d, e, f, g;
                for (g = a.split(","), b = ~g[0].indexOf("base64") ? atob(g[1]) : decodeURIComponent(g[1]), d = new ArrayBuffer(b.length), c = new Uint8Array(d), e = 0; e < b.length; e++) c[e] = b.charCodeAt(e);
                return f = g[0].split(":")[1].split(";")[0],
                this.arrayBufferToBlob(d, f)
            },
            dataURL2ArrayBuffer: function(a) {
                var b, c, d, e;
                for (e = a.split(","), b = ~e[0].indexOf("base64") ? atob(e[1]) : decodeURIComponent(e[1]), c = new Uint8Array(b.length), d = 0; d < b.length; d++) c[d] = b.charCodeAt(d);
                return c.buffer
            },
            arrayBufferToBlob: function(b, c) {
                var d, e = a.BlobBuilder || a.WebKitBlobBuilder;
                return e ? (d = new e, d.append(b), d.getBlob(c)) : new Blob([b], c ? {
                    type: c
                }: {})
            },
            canvasToDataUrl: function(a, b, c) {
                return a.toDataURL(b, c / 100)
            },
            parseMeta: function(a, b) {
                b(!1, {})
            },
            updateImageHead: function(a) {
                return a
            }
        }
    }),
    b("runtime/html5/imagemeta", ["runtime/html5/util"],
    function(a) {
        var b;
        return b = {
            parsers: {
                65505 : []
            },
            maxMetaDataSize: 262144,
            parse: function(a, b) {
                var c = this,
                d = new FileReader;
                d.onload = function() {
                    b(!1, c._parse(this.result)),
                    d = d.onload = d.onerror = null
                },
                d.onerror = function(a) {
                    b(a.message),
                    d = d.onload = d.onerror = null
                },
                a = a.slice(0, c.maxMetaDataSize),
                d.readAsArrayBuffer(a.getSource())
            },
            _parse: function(a, c) {
                if (! (a.byteLength < 6)) {
                    var d, e, f, g, h = new DataView(a),
                    i = 2,
                    j = h.byteLength - 4,
                    k = i,
                    l = {};
                    if (65496 === h.getUint16(0)) {
                        for (; j > i && (d = h.getUint16(i), d >= 65504 && 65519 >= d || 65534 === d) && (e = h.getUint16(i + 2) + 2, !(i + e > h.byteLength));) {
                            if (f = b.parsers[d], !c && f) for (g = 0; g < f.length; g += 1) f[g].call(b, h, i, e, l);
                            i += e,
                            k = i
                        }
                        k > 6 && (l.imageHead = a.slice ? a.slice(2, k) : new Uint8Array(a).subarray(2, k))
                    }
                    return l
                }
            },
            updateImageHead: function(a, b) {
                var c, d, e, f = this._parse(a, !0);
                return e = 2,
                f.imageHead && (e = 2 + f.imageHead.byteLength),
                d = a.slice ? a.slice(e) : new Uint8Array(a).subarray(e),
                c = new Uint8Array(b.byteLength + 2 + d.byteLength),
                c[0] = 255,
                c[1] = 216,
                c.set(new Uint8Array(b), 2),
                c.set(new Uint8Array(d), b.byteLength + 2),
                c.buffer
            }
        },
        a.parseMeta = function() {
            return b.parse.apply(b, arguments)
        },
        a.updateImageHead = function() {
            return b.updateImageHead.apply(b, arguments)
        },
        b
    }),
    b("runtime/html5/imagemeta/exif", ["base", "runtime/html5/imagemeta"],
    function(a, b) {
        var c = {};
        return c.ExifMap = function() {
            return this
        },
        c.ExifMap.prototype.map = {
            Orientation: 274
        },
        c.ExifMap.prototype.get = function(a) {
            return this[a] || this[this.map[a]]
        },
        c.exifTagTypes = {
            1 : {
                getValue: function(a, b) {
                    return a.getUint8(b)
                },
                size: 1
            },
            2 : {
                getValue: function(a, b) {
                    return String.fromCharCode(a.getUint8(b))
                },
                size: 1,
                ascii: !0
            },
            3 : {
                getValue: function(a, b, c) {
                    return a.getUint16(b, c)
                },
                size: 2
            },
            4 : {
                getValue: function(a, b, c) {
                    return a.getUint32(b, c)
                },
                size: 4
            },
            5 : {
                getValue: function(a, b, c) {
                    return a.getUint32(b, c) / a.getUint32(b + 4, c)
                },
                size: 8
            },
            9 : {
                getValue: function(a, b, c) {
                    return a.getInt32(b, c)
                },
                size: 4
            },
            10 : {
                getValue: function(a, b, c) {
                    return a.getInt32(b, c) / a.getInt32(b + 4, c)
                },
                size: 8
            }
        },
        c.exifTagTypes[7] = c.exifTagTypes[1],
        c.getExifValue = function(b, d, e, f, g, h) {
            var i, j, k, l, m, n, o = c.exifTagTypes[f];
            if (!o) return void a.log("Invalid Exif data: Invalid tag type.");
            if (i = o.size * g, j = i > 4 ? d + b.getUint32(e + 8, h) : e + 8, j + i > b.byteLength) return void a.log("Invalid Exif data: Invalid data offset.");
            if (1 === g) return o.getValue(b, j, h);
            for (k = [], l = 0; g > l; l += 1) k[l] = o.getValue(b, j + l * o.size, h);
            if (o.ascii) {
                for (m = "", l = 0; l < k.length && (n = k[l], "\x00" !== n); l += 1) m += n;
                return m
            }
            return k
        },
        c.parseExifTag = function(a, b, d, e, f) {
            var g = a.getUint16(d, e);
            f.exif[g] = c.getExifValue(a, b, d, a.getUint16(d + 2, e), a.getUint32(d + 4, e), e)
        },
        c.parseExifTags = function(b, c, d, e, f) {
            var g, h, i;
            if (d + 6 > b.byteLength) return void a.log("Invalid Exif data: Invalid directory offset.");
            if (g = b.getUint16(d, e), h = d + 2 + 12 * g, h + 4 > b.byteLength) return void a.log("Invalid Exif data: Invalid directory size.");
            for (i = 0; g > i; i += 1) this.parseExifTag(b, c, d + 2 + 12 * i, e, f);
            return b.getUint32(h, e)
        },
        c.parseExifData = function(b, d, e, f) {
            var g, h, i = d + 10;
            if (1165519206 === b.getUint32(d + 4)) {
                if (i + 8 > b.byteLength) return void a.log("Invalid Exif data: Invalid segment size.");
                if (0 !== b.getUint16(d + 8)) return void a.log("Invalid Exif data: Missing byte alignment offset.");
                switch (b.getUint16(i)) {
                case 18761:
                    g = !0;
                    break;
                case 19789:
                    g = !1;
                    break;
                default:
                    return void a.log("Invalid Exif data: Invalid byte alignment marker.")
                }
                if (42 !== b.getUint16(i + 2, g)) return void a.log("Invalid Exif data: Missing TIFF marker.");
                h = b.getUint32(i + 4, g),
                f.exif = new c.ExifMap,
                h = c.parseExifTags(b, i, i + h, g, f)
            }
        },
        b.parsers[65505].push(c.parseExifData),
        c
    }),
    b("runtime/html5/jpegencoder", [],
    function() {
        function a(a) {
            function b(a) {
                for (var b = [16, 11, 10, 16, 24, 40, 51, 61, 12, 12, 14, 19, 26, 58, 60, 55, 14, 13, 16, 24, 40, 57, 69, 56, 14, 17, 22, 29, 51, 87, 80, 62, 18, 22, 37, 56, 68, 109, 103, 77, 24, 35, 55, 64, 81, 104, 113, 92, 49, 64, 78, 87, 103, 121, 120, 101, 72, 92, 95, 98, 112, 100, 103, 99], c = 0; 64 > c; c++) {
                    var d = y((b[c] * a + 50) / 100);
                    1 > d ? d = 1 : d > 255 && (d = 255),
                    z[P[c]] = d
                }
                for (var e = [17, 18, 24, 47, 99, 99, 99, 99, 18, 21, 26, 66, 99, 99, 99, 99, 24, 26, 56, 99, 99, 99, 99, 99, 47, 66, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99], f = 0; 64 > f; f++) {
                    var g = y((e[f] * a + 50) / 100);
                    1 > g ? g = 1 : g > 255 && (g = 255),
                    A[P[f]] = g
                }
                for (var h = [1, 1.387039845, 1.306562965, 1.175875602, 1, .785694958, .5411961, .275899379], i = 0, j = 0; 8 > j; j++) for (var k = 0; 8 > k; k++) B[i] = 1 / (z[P[i]] * h[j] * h[k] * 8),
                C[i] = 1 / (A[P[i]] * h[j] * h[k] * 8),
                i++
            }
            function c(a, b) {
                for (var c = 0,
                d = 0,
                e = new Array,
                f = 1; 16 >= f; f++) {
                    for (var g = 1; g <= a[f]; g++) e[b[d]] = [],
                    e[b[d]][0] = c,
                    e[b[d]][1] = f,
                    d++,
                    c++;
                    c *= 2
                }
                return e
            }
            function d() {
                t = c(Q, R),
                u = c(U, V),
                v = c(S, T),
                w = c(W, X)
            }
            function e() {
                for (var a = 1,
                b = 2,
                c = 1; 15 >= c; c++) {
                    for (var d = a; b > d; d++) E[32767 + d] = c,
                    D[32767 + d] = [],
                    D[32767 + d][1] = c,
                    D[32767 + d][0] = d;
                    for (var e = -(b - 1); - a >= e; e++) E[32767 + e] = c,
                    D[32767 + e] = [],
                    D[32767 + e][1] = c,
                    D[32767 + e][0] = b - 1 + e;
                    a <<= 1,
                    b <<= 1
                }
            }
            function f() {
                for (var a = 0; 256 > a; a++) O[a] = 19595 * a,
                O[a + 256 >> 0] = 38470 * a,
                O[a + 512 >> 0] = 7471 * a + 32768,
                O[a + 768 >> 0] = -11059 * a,
                O[a + 1024 >> 0] = -21709 * a,
                O[a + 1280 >> 0] = 32768 * a + 8421375,
                O[a + 1536 >> 0] = -27439 * a,
                O[a + 1792 >> 0] = -5329 * a
            }
            function g(a) {
                for (var b = a[0], c = a[1] - 1; c >= 0;) b & 1 << c && (I |= 1 << J),
                c--,
                J--,
                0 > J && (255 == I ? (h(255), h(0)) : h(I), J = 7, I = 0)
            }
            function h(a) {
                H.push(N[a])
            }
            function i(a) {
                h(a >> 8 & 255),
                h(255 & a)
            }
            function j(a, b) {
                var c, d, e, f, g, h, i, j, k, l = 0,
                m = 8,
                n = 64;
                for (k = 0; m > k; ++k) {
                    c = a[l],
                    d = a[l + 1],
                    e = a[l + 2],
                    f = a[l + 3],
                    g = a[l + 4],
                    h = a[l + 5],
                    i = a[l + 6],
                    j = a[l + 7];
                    var o = c + j,
                    p = c - j,
                    q = d + i,
                    r = d - i,
                    s = e + h,
                    t = e - h,
                    u = f + g,
                    v = f - g,
                    w = o + u,
                    x = o - u,
                    y = q + s,
                    z = q - s;
                    a[l] = w + y,
                    a[l + 4] = w - y;
                    var A = .707106781 * (z + x);
                    a[l + 2] = x + A,
                    a[l + 6] = x - A,
                    w = v + t,
                    y = t + r,
                    z = r + p;
                    var B = .382683433 * (w - z),
                    C = .5411961 * w + B,
                    D = 1.306562965 * z + B,
                    E = .707106781 * y,
                    G = p + E,
                    H = p - E;
                    a[l + 5] = H + C,
                    a[l + 3] = H - C,
                    a[l + 1] = G + D,
                    a[l + 7] = G - D,
                    l += 8
                }
                for (l = 0, k = 0; m > k; ++k) {
                    c = a[l],
                    d = a[l + 8],
                    e = a[l + 16],
                    f = a[l + 24],
                    g = a[l + 32],
                    h = a[l + 40],
                    i = a[l + 48],
                    j = a[l + 56];
                    var I = c + j,
                    J = c - j,
                    K = d + i,
                    L = d - i,
                    M = e + h,
                    N = e - h,
                    O = f + g,
                    P = f - g,
                    Q = I + O,
                    R = I - O,
                    S = K + M,
                    T = K - M;
                    a[l] = Q + S,
                    a[l + 32] = Q - S;
                    var U = .707106781 * (T + R);
                    a[l + 16] = R + U,
                    a[l + 48] = R - U,
                    Q = P + N,
                    S = N + L,
                    T = L + J;
                    var V = .382683433 * (Q - T),
                    W = .5411961 * Q + V,
                    X = 1.306562965 * T + V,
                    Y = .707106781 * S,
                    Z = J + Y,
                    $ = J - Y;
                    a[l + 40] = $ + W,
                    a[l + 24] = $ - W,
                    a[l + 8] = Z + X,
                    a[l + 56] = Z - X,
                    l++
                }
                var _;
                for (k = 0; n > k; ++k) _ = a[k] * b[k],
                F[k] = _ > 0 ? _ + .5 | 0 : _ - .5 | 0;
                return F
            }
            function k() {
                i(65504),
                i(16),
                h(74),
                h(70),
                h(73),
                h(70),
                h(0),
                h(1),
                h(1),
                h(0),
                i(1),
                i(1),
                h(0),
                h(0)
            }
            function l(a, b) {
                i(65472),
                i(17),
                h(8),
                i(b),
                i(a),
                h(3),
                h(1),
                h(17),
                h(0),
                h(2),
                h(17),
                h(1),
                h(3),
                h(17),
                h(1)
            }
            function m() {
                i(65499),
                i(132),
                h(0);
                for (var a = 0; 64 > a; a++) h(z[a]);
                h(1);
                for (var b = 0; 64 > b; b++) h(A[b])
            }
            function n() {
                i(65476),
                i(418),
                h(0);
                for (var a = 0; 16 > a; a++) h(Q[a + 1]);
                for (var b = 0; 11 >= b; b++) h(R[b]);
                h(16);
                for (var c = 0; 16 > c; c++) h(S[c + 1]);
                for (var d = 0; 161 >= d; d++) h(T[d]);
                h(1);
                for (var e = 0; 16 > e; e++) h(U[e + 1]);
                for (var f = 0; 11 >= f; f++) h(V[f]);
                h(17);
                for (var g = 0; 16 > g; g++) h(W[g + 1]);
                for (var j = 0; 161 >= j; j++) h(X[j])
            }
            function o() {
                i(65498),
                i(12),
                h(3),
                h(1),
                h(0),
                h(2),
                h(17),
                h(3),
                h(17),
                h(0),
                h(63),
                h(0)
            }
            function p(a, b, c, d, e) {
                for (var f, h = e[0], i = e[240], k = 16, l = 63, m = 64, n = j(a, b), o = 0; m > o; ++o) G[P[o]] = n[o];
                var p = G[0] - c;
                c = G[0],
                0 == p ? g(d[0]) : (f = 32767 + p, g(d[E[f]]), g(D[f]));
                for (var q = 63; q > 0 && 0 == G[q]; q--);
                if (0 == q) return g(h),
                c;
                for (var r, s = 1; q >= s;) {
                    for (var t = s; 0 == G[s] && q >= s; ++s);
                    var u = s - t;
                    if (u >= k) {
                        r = u >> 4;
                        for (var v = 1; r >= v; ++v) g(i);
                        u = 15 & u
                    }
                    f = 32767 + G[s],
                    g(e[(u << 4) + E[f]]),
                    g(D[f]),
                    s++
                }
                return q != l && g(h),
                c
            }
            function q() {
                for (var a = String.fromCharCode,
                b = 0; 256 > b; b++) N[b] = a(b)
            }
            function r(a) {
                if (0 >= a && (a = 1), a > 100 && (a = 100), x != a) {
                    var c = 0;
                    c = Math.floor(50 > a ? 5e3 / a: 200 - 2 * a),
                    b(c),
                    x = a
                }
            }
            function s() {
                a || (a = 50),
                q(),
                d(),
                e(),
                f(),
                r(a)
            }
            var t, u, v, w, x, y = (Math.round, Math.floor),
            z = new Array(64),
            A = new Array(64),
            B = new Array(64),
            C = new Array(64),
            D = new Array(65535),
            E = new Array(65535),
            F = new Array(64),
            G = new Array(64),
            H = [],
            I = 0,
            J = 7,
            K = new Array(64),
            L = new Array(64),
            M = new Array(64),
            N = new Array(256),
            O = new Array(2048),
            P = [0, 1, 5, 6, 14, 15, 27, 28, 2, 4, 7, 13, 16, 26, 29, 42, 3, 8, 12, 17, 25, 30, 41, 43, 9, 11, 18, 24, 31, 40, 44, 53, 10, 19, 23, 32, 39, 45, 52, 54, 20, 22, 33, 38, 46, 51, 55, 60, 21, 34, 37, 47, 50, 56, 59, 61, 35, 36, 48, 49, 57, 58, 62, 63],
            Q = [0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
            R = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11],
            S = [0, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125],
            T = [1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, 129, 145, 161, 8, 35, 66, 177, 193, 21, 82, 209, 240, 36, 51, 98, 114, 130, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250],
            U = [0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0],
            V = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11],
            W = [0, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119],
            X = [0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, 129, 8, 20, 66, 145, 161, 177, 193, 9, 35, 51, 82, 240, 21, 98, 114, 209, 10, 22, 36, 52, 225, 37, 241, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 130, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 226, 227, 228, 229, 230, 231, 232, 233, 234, 242, 243, 244, 245, 246, 247, 248, 249, 250];
            this.encode = function(a, b) {
                b && r(b),
                H = new Array,
                I = 0,
                J = 7,
                i(65496),
                k(),
                m(),
                l(a.width, a.height),
                n(),
                o();
                var c = 0,
                d = 0,
                e = 0;
                I = 0,
                J = 7,
                this.encode.displayName = "_encode_";
                for (var f, h, j, q, s, x, y, z, A, D = a.data,
                E = a.width,
                F = a.height,
                G = 4 * E,
                N = 0; F > N;) {
                    for (f = 0; G > f;) {
                        for (s = G * N + f, x = s, y = -1, z = 0, A = 0; 64 > A; A++) z = A >> 3,
                        y = 4 * (7 & A),
                        x = s + z * G + y,
                        N + z >= F && (x -= G * (N + 1 + z - F)),
                        f + y >= G && (x -= f + y - G + 4),
                        h = D[x++],
                        j = D[x++],
                        q = D[x++],
                        K[A] = (O[h] + O[j + 256 >> 0] + O[q + 512 >> 0] >> 16) - 128,
                        L[A] = (O[h + 768 >> 0] + O[j + 1024 >> 0] + O[q + 1280 >> 0] >> 16) - 128,
                        M[A] = (O[h + 1280 >> 0] + O[j + 1536 >> 0] + O[q + 1792 >> 0] >> 16) - 128;
                        c = p(K, B, c, t, v),
                        d = p(L, C, d, u, w),
                        e = p(M, C, e, u, w),
                        f += 32
                    }
                    N += 8
                }
                if (J >= 0) {
                    var P = [];
                    P[1] = J + 1,
                    P[0] = (1 << J + 1) - 1,
                    g(P)
                }
                i(65497);
                var Q = "data:image/jpeg;base64," + btoa(H.join(""));
                return H = [],
                Q
            },
            s()
        }
        return a.encode = function(b, c) {
            var d = new a(c);
            return d.encode(b)
        },
        a
    }),
    b("runtime/html5/androidpatch", ["runtime/html5/util", "runtime/html5/jpegencoder", "base"],
    function(a, b, c) {
        var d, e = a.canvasToDataUrl;
        a.canvasToDataUrl = function(a, f, g) {
            var h, i, j, k, l;
            return c.os.android ? ("image/jpeg" === f && "undefined" == typeof d && (k = e.apply(null, arguments), l = k.split(","), k = ~l[0].indexOf("base64") ? atob(l[1]) : decodeURIComponent(l[1]), k = k.substring(0, 2), d = 255 === k.charCodeAt(0) && 216 === k.charCodeAt(1)), "image/jpeg" !== f || d ? e.apply(null, arguments) : (i = a.width, j = a.height, h = a.getContext("2d"), b.encode(h.getImageData(0, 0, i, j), g))) : e.apply(null, arguments)
        }
    }),
    b("runtime/html5/image", ["base", "runtime/html5/runtime", "runtime/html5/util"],
    function(a, b, c) {
        var d = "data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D";
        return b.register("Image", {
            modified: !1,
            init: function() {
                var a = this,
                b = new Image;
                b.onload = function() {
                    a._info = {
                        type: a.type,
                        width: this.width,
                        height: this.height
                    },
                    a._metas || "image/jpeg" !== a.type ? a.owner.trigger("load") : c.parseMeta(a._blob,
                    function(b, c) {
                        a._metas = c,
                        a.owner.trigger("load")
                    })
                },
                b.onerror = function() {
                    a.owner.trigger("error")
                },
                a._img = b
            },
            loadFromBlob: function(a) {
                var b = this,
                d = b._img;
                b._blob = a,
                b.type = a.type,
                d.src = c.createObjectURL(a.getSource()),
                b.owner.once("load",
                function() {
                    c.revokeObjectURL(d.src)
                })
            },
            resize: function(a, b) {
                var c = this._canvas || (this._canvas = document.createElement("canvas"));
                this._resize(this._img, c, a, b),
                this._blob = null,
                this.modified = !0,
                this.owner.trigger("complete")
            },
            getAsBlob: function(a) {
                var b, d = this._blob,
                e = this.options;
                if (a = a || this.type, this.modified || this.type !== a) {
                    if (b = this._canvas, "image/jpeg" === a) {
                        if (d = c.canvasToDataUrl(b, "image/jpeg", e.quality), e.preserveHeaders && this._metas && this._metas.imageHead) return d = c.dataURL2ArrayBuffer(d),
                        d = c.updateImageHead(d, this._metas.imageHead),
                        d = c.arrayBufferToBlob(d, a)
                    } else d = c.canvasToDataUrl(b, a);
                    d = c.dataURL2Blob(d)
                }
                return d
            },
            getAsDataUrl: function(a) {
                var b = this.options;
                return a = a || this.type,
                "image/jpeg" === a ? c.canvasToDataUrl(this._canvas, a, b.quality) : this._canvas.toDataURL(a)
            },
            getOrientation: function() {
                return this._metas && this._metas.exif && this._metas.exif.get("Orientation") || 1
            },
            info: function(a) {
                return a ? (this._info = a, this) : this._info
            },
            meta: function(a) {
                return a ? (this._meta = a, this) : this._meta
            },
            destroy: function() {
                var a = this._canvas;
                this._img.onload = null,
                a && (a.getContext("2d").clearRect(0, 0, a.width, a.height), a.width = a.height = 0, this._canvas = null),
                this._img.src = d,
                this._img = this._blob = null
            },
            _resize: function(a, b, c, d) {
                var e, f, g, h, i, j = this.options,
                k = a.width,
                l = a.height,
                m = this.getOrientation();~ [5, 6, 7, 8].indexOf(m) && (c ^= d, d ^= c, c ^= d),
                e = Math[j.crop ? "max": "min"](c / k, d / l),
                j.allowMagnify || (e = Math.min(1, e)),
                f = k * e,
                g = l * e,
                j.crop ? (b.width = c, b.height = d) : (b.width = f, b.height = g),
                h = (b.width - f) / 2,
                i = (b.height - g) / 2,
                j.preserveHeaders || this._rotate2Orientaion(b, m),
                this._renderImageToCanvas(b, a, h, i, f, g)
            },
            _rotate2Orientaion: function(a, b) {
                var c = a.width,
                d = a.height,
                e = a.getContext("2d");
                switch (b) {
                case 5:
                case 6:
                case 7:
                case 8:
                    a.width = d,
                    a.height = c
                }
                switch (b) {
                case 2:
                    e.translate(c, 0),
                    e.scale( - 1, 1);
                    break;
                case 3:
                    e.translate(c, d),
                    e.rotate(Math.PI);
                    break;
                case 4:
                    e.translate(0, d),
                    e.scale(1, -1);
                    break;
                case 5:
                    e.rotate(.5 * Math.PI),
                    e.scale(1, -1);
                    break;
                case 6:
                    e.rotate(.5 * Math.PI),
                    e.translate(0, -d);
                    break;
                case 7:
                    e.rotate(.5 * Math.PI),
                    e.translate(c, -d),
                    e.scale( - 1, 1);
                    break;
                case 8:
                    e.rotate( - .5 * Math.PI),
                    e.translate( - c, 0)
                }
            },
            _renderImageToCanvas: function() {
                function b(a) {
                    var b, c, d = a.naturalWidth,
                    e = a.naturalHeight;
                    return d * e > 1048576 ? (b = document.createElement("canvas"), b.width = b.height = 1, c = b.getContext("2d"), c.drawImage(a, -d + 1, 0), 0 === c.getImageData(0, 0, 1, 1).data[3]) : !1
                }
                function c(a, b, c) {
                    var d, e, f, g = document.createElement("canvas"),
                    h = g.getContext("2d"),
                    i = 0,
                    j = c,
                    k = c;
                    for (g.width = 1, g.height = c, h.drawImage(a, 0, 0), d = h.getImageData(0, 0, 1, c).data; k > i;) e = d[4 * (k - 1) + 3],
                    0 === e ? j = k: i = k,
                    k = j + i >> 1;
                    return f = k / c,
                    0 === f ? 1 : f
                }
                return a.os.ios && 6 === ~~a.os.ios ?
                function(a, d, e, f, g, h) {
                    var i, j, k, l, m, n, o, p = d.naturalWidth,
                    q = d.naturalHeight,
                    r = a.getContext("2d"),
                    s = b(d),
                    t = "image/jpeg" === this.type,
                    u = 1024,
                    v = 0,
                    w = 0;
                    for (s && (p /= 2, q /= 2), r.save(), i = document.createElement("canvas"), i.width = i.height = u, j = i.getContext("2d"), k = t ? c(d, p, q) : 1, l = Math.ceil(u * g / p), m = Math.ceil(u * h / q / k); q > v;) {
                        for (n = 0, o = 0; p > n;) j.clearRect(0, 0, u, u),
                        j.drawImage(d, -n, -v),
                        r.drawImage(i, 0, 0, u, u, e + o, f + w, l, m),
                        n += u,
                        o += l;
                        v += u,
                        w += m
                    }
                    r.restore(),
                    i = j = null
                }: function(a, b, c, d, e, f) {
                    a.getContext("2d").drawImage(b, c, d, e, f)
                }
            } ()
        })
    }),
    b("runtime/html5/transport", ["base", "runtime/html5/runtime"],
    function(a, b) {
        var c = a.noop,
        d = a.$;
        return b.register("Transport", {
            init: function() {
                this._status = 0,
                this._response = null
            },
            send: function() {
                var b, c, e, f = this.owner,
                g = this.options,
                h = this._initAjax(),
                i = f._blob,
                j = g.server;
                g.sendAsBinary ? (j += (/\?/.test(j) ? "&": "?") + d.param(f._formData), c = i.getSource()) : (b = new FormData, d.each(f._formData,
                function(a, c) {
                    b.append(a, c)
                }), b.append(g.fileVal, i.getSource(), g.filename || f._formData.name || "")),
                g.withCredentials && "withCredentials" in h ? (h.open(g.method, j, !0), h.withCredentials = !0) : h.open(g.method, j),
                this._setRequestHeader(h, g.headers),
                c ? (h.overrideMimeType("application/octet-stream"), a.os.android ? (e = new FileReader, e.onload = function() {
                    h.send(this.result),
                    e = e.onload = null
                },
                e.readAsArrayBuffer(c)) : h.send(c)) : h.send(b)
            },
            getResponse: function() {
                return this._response
            },
            getResponseAsJson: function() {
                return this._parseJson(this._response)
            },
            getStatus: function() {
                return this._status
            },
            abort: function() {
                var a = this._xhr;
                a && (a.upload.onprogress = c, a.onreadystatechange = c, a.abort(), this._xhr = a = null)
            },
            destroy: function() {
                this.abort()
            },
            _initAjax: function() {
                var a = this,
                b = new XMLHttpRequest,
                d = this.options;
                return ! d.withCredentials || "withCredentials" in b || "undefined" == typeof XDomainRequest || (b = new XDomainRequest),
                b.upload.onprogress = function(b) {
                    var c = 0;
                    return b.lengthComputable && (c = b.loaded / b.total),
                    a.trigger("progress", c)
                },
                b.onreadystatechange = function() {
                    return 4 === b.readyState ? (b.upload.onprogress = c, b.onreadystatechange = c, a._xhr = null, a._status = b.status, b.status >= 200 && b.status < 300 ? (a._response = b.responseText, a.trigger("load")) : b.status >= 500 && b.status < 600 ? (a._response = b.responseText, a.trigger("error", "server")) : a.trigger("error", a._status ? "http": "abort")) : void 0
                },
                a._xhr = b,
                b
            },
            _setRequestHeader: function(a, b) {
                d.each(b,
                function(b, c) {
                    a.setRequestHeader(b, c)
                })
            },
            _parseJson: function(a) {
                var b;
                try {
                    b = JSON.parse(a)
                } catch(c) {
                    b = {}
                }
                return b
            }
        })
    }),
    b("runtime/flash/runtime", ["base", "runtime/runtime", "runtime/compbase"],
    function(b, c, d) {
        function e() {
            var a;
            try {
                a = navigator.plugins["Shockwave Flash"],
                a = a.description
            } catch(b) {
                try {
                    a = new ActiveXObject("ShockwaveFlash.ShockwaveFlash").GetVariable("$version")
                } catch(c) {
                    a = "0.0"
                }
            }
            return a = a.match(/\d+/g),
            parseFloat(a[0] + "." + a[1], 10)
        }
        function f() {
            function d(a, b) {
                var c, d, e = a.type || a;
                c = e.split("::"),
                d = c[0],
                e = c[1],
                "Ready" === e && d === j.uid ? j.trigger("ready") : f[d] && f[d].trigger(e.toLowerCase(), a, b)
            }
            var e = {},
            f = {},
            g = this.destory,
            j = this,
            k = b.guid("webuploader_");
            c.apply(j, arguments),
            j.type = h,
            j.exec = function(a, c) {
                var d, g = this,
                h = g.uid,
                k = b.slice(arguments, 2);
                return f[h] = g,
                i[a] && (e[h] || (e[h] = new i[a](g, j)), d = e[h], d[c]) ? d[c].apply(d, k) : j.flashExec.apply(g, arguments)
            },
            a[k] = function() {
                var a = arguments;
                setTimeout(function() {
                    d.apply(null, a)
                },
                1)
            },
            this.jsreciver = k,
            this.destory = function() {
                return g && g.apply(this, arguments)
            },
            this.flashExec = function(a, c) {
                var d = j.getFlash(),
                e = b.slice(arguments, 2);
                return d.exec(this.uid, a, c, e)
            }
        }
        var g = b.$,
        h = "flash",
        i = {};
        return b.inherits(c, {
            constructor: f,
            init: function() {
                var a, c = this.getContainer(),
                d = this.options;
                c.css({
                    position: "absolute",
                    top: "-8px",
                    left: "-8px",
                    width: "9px",
                    height: "9px",
                    overflow: "hidden"
                }),
                a = '<object id="' + this.uid + '" type="application/x-shockwave-flash" data="' + d.swf + '" ',
                b.isIE && (a += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" '),
                a += 'width="100%" height="100%" style="outline:0"><param name="movie" value="' + d.swf + '" /><param name="flashvars" value="uid=' + this.uid + "&jsreciver=" + this.jsreciver + '" /><param name="wmode" value="transparent" /><param name="allowscriptaccess" value="always" /></object>',
                c.html(a)
            },
            getFlash: function() {
                return this._flash ? this._flash: (this._flash = g("#" + this.uid).get(0), this._flash)
            }
        }),
        f.register = function(a, c) {
            return c = i[a] = b.inherits(d, g.extend({
                flashExec: function() {
                    var a = this.owner,
                    b = this.getRuntime();
                    return b.flashExec.apply(a, arguments)
                }
            },
            c))
        },
        e() >= 11.3 && c.addRuntime(h, f),
        f
    }),
    b("runtime/flash/filepicker", ["base", "runtime/flash/runtime"],
    function(a, b) {
        var c = a.$;
        return b.register("FilePicker", {
            init: function(a) {
                var b, d, e = c.extend({},
                a);
                for (b = e.accept && e.accept.length, d = 0; b > d; d++) e.accept[d].title || (e.accept[d].title = "Files");
                delete e.button,
                delete e.container,
                this.flashExec("FilePicker", "init", e)
            },
            destroy: function() {}
        })
    }),
    b("runtime/flash/image", ["runtime/flash/runtime"],
    function(a) {
        return a.register("Image", {
            loadFromBlob: function(a) {
                var b = this.owner;
                b.info() && this.flashExec("Image", "info", b.info()),
                b.meta() && this.flashExec("Image", "meta", b.meta()),
                this.flashExec("Image", "loadFromBlob", a.uid)
            }
        })
    }),
    b("runtime/flash/transport", ["base", "runtime/flash/runtime", "runtime/client"],
    function(a, b, c) {
        var d = a.$;
        return b.register("Transport", {
            init: function() {
                this._status = 0,
                this._response = null,
                this._responseJson = null
            },
            send: function() {
                var a, b = this.owner,
                c = this.options,
                e = this._initAjax(),
                f = b._blob,
                g = c.server;
                e.connectRuntime(f.ruid),
                c.sendAsBinary ? (g += (/\?/.test(g) ? "&": "?") + d.param(b._formData), a = f.uid) : (d.each(b._formData,
                function(a, b) {
                    e.exec("append", a, b)
                }), e.exec("appendBlob", c.fileVal, f.uid, c.filename || b._formData.name || "")),
                this._setRequestHeader(e, c.headers),
                e.exec("send", {
                    method: c.method,
                    url: g
                },
                a)
            },
            getStatus: function() {
                return this._status
            },
            getResponse: function() {
                return this._response
            },
            getResponseAsJson: function() {
                return this._responseJson
            },
            abort: function() {
                var a = this._xhr;
                a && (a.exec("abort"), a.destroy(), this._xhr = a = null)
            },
            destroy: function() {
                this.abort()
            },
            _initAjax: function() {
                var a = this,
                b = new c("XMLHttpRequest");
                return b.on("uploadprogress progress",
                function(b) {
                    return a.trigger("progress", b.loaded / b.total)
                }),
                b.on("load",
                function() {
                    var c = b.exec("getStatus"),
                    d = "";
                    return b.off(),
                    a._xhr = null,
                    c >= 200 && 300 > c ? (a._response = b.exec("getResponse"), a._responseJson = b.exec("getResponseAsJson")) : c >= 500 && 600 > c ? (a._response = b.exec("getResponse"), a._responseJson = b.exec("getResponseAsJson"), d = "server") : d = "http",
                    b.destroy(),
                    b = null,
                    d ? a.trigger("error", d) : a.trigger("load")
                }),
                b.on("error",
                function() {
                    b.off(),
                    a._xhr = null,
                    a.trigger("error", "http")
                }),
                a._xhr = b,
                b
            },
            _setRequestHeader: function(a, b) {
                d.each(b,
                function(b, c) {
                    a.exec("setRequestHeader", b, c)
                })
            }
        })
    }),
    b("preset/all", ["base", "widgets/filednd", "widgets/filepaste", "widgets/filepicker", "widgets/image", "widgets/queue", "widgets/runtime", "widgets/upload", "widgets/validator", "runtime/html5/blob", "runtime/html5/dnd", "runtime/html5/filepaste", "runtime/html5/filepicker", "runtime/html5/imagemeta/exif", "runtime/html5/androidpatch", "runtime/html5/image", "runtime/html5/transport", "runtime/flash/filepicker", "runtime/flash/image", "runtime/flash/transport"],
    function(a) {
        return a
    }),
    b("webuploader", ["preset/all"],
    function(a) {
        return a
    }),
    c("webuploader")
});