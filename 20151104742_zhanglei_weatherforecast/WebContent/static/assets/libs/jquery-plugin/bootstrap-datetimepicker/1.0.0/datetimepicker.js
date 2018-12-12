define("jquery-plugin/bootstrap-datetimepicker/1.0.0/datetimepicker", ["$", "./datetimepicker.css", "./i18n/{locale}"],
function(a) {
    a("$"),
    a("./datetimepicker.css"),
    !
    function(a) {
        function b() {
            return new Date(Date.UTC.apply(Date, arguments))
        }
        var c = function(b, c) {
            var f = this;
            this.element = a(b),
            this.language = c.language || this.element.data("date-language") || "en",
            this.language = this.language in d ? this.language: "en",
            this.isRTL = d[this.language].rtl || !1,
            this.formatType = c.formatType || this.element.data("format-type") || "standard",
            this.format = e.parseFormat(c.format || this.element.data("date-format") || e.getDefaultFormat(this.formatType, "input"), this.formatType),
            this.isInline = !1,
            this.isVisible = !1,
            this.isInput = this.element.is("input"),
            this.component = this.element.is(".date") ? this.element.find(".add-on .icon-th, .add-on .icon-time, .add-on .icon-calendar").parent() : !1,
            this.componentReset = this.element.is(".date") ? this.element.find(".add-on .icon-remove").parent() : !1,
            this.hasInput = this.component && this.element.find("input").length,
            this.component && 0 === this.component.length && (this.component = !1),
            this.linkField = c.linkField || this.element.data("link-field") || !1,
            this.linkFormat = e.parseFormat(c.linkFormat || this.element.data("link-format") || e.getDefaultFormat(this.formatType, "link"), this.formatType),
            this.minuteStep = c.minuteStep || this.element.data("minute-step") || 5,
            this.pickerPosition = c.pickerPosition || this.element.data("picker-position") || "bottom-right",
            this.showMeridian = c.showMeridian || this.element.data("show-meridian") || !1,
            this.initialDate = c.initialDate || new Date,
            this._attachEvents(),
            this.formatViewType = "datetime",
            "formatViewType" in c ? this.formatViewType = c.formatViewType: "formatViewType" in this.element.data() && (this.formatViewType = this.element.data("formatViewType")),
            this.minView = 0,
            "minView" in c ? this.minView = c.minView: "minView" in this.element.data() && (this.minView = this.element.data("min-view")),
            this.minView = e.convertViewMode(this.minView),
            this.maxView = e.modes.length - 1,
            "maxView" in c ? this.maxView = c.maxView: "maxView" in this.element.data() && (this.maxView = this.element.data("max-view")),
            this.maxView = e.convertViewMode(this.maxView),
            this.startViewMode = 2,
            "startView" in c ? this.startViewMode = c.startView: "startView" in this.element.data() && (this.startViewMode = this.element.data("start-view")),
            this.startViewMode = e.convertViewMode(this.startViewMode),
            this.viewMode = this.startViewMode,
            this.viewSelect = this.minView,
            "viewSelect" in c ? this.viewSelect = c.viewSelect: "viewSelect" in this.element.data() && (this.viewSelect = this.element.data("view-select")),
            this.viewSelect = e.convertViewMode(this.viewSelect),
            this.forceParse = !0,
            "forceParse" in c ? this.forceParse = c.forceParse: "dateForceParse" in this.element.data() && (this.forceParse = this.element.data("date-force-parse")),
            this.picker = a(e.template).appendTo(this.isInline ? this.element: "body").on({
                click: a.proxy(this.click, this),
                mousedown: a.proxy(this.mousedown, this)
            }),
            this.isInline ? this.picker.addClass("datetimepicker-inline") : this.picker.addClass("datetimepicker-dropdown-" + this.pickerPosition + " dropdown-menu"),
            this.isRTL && (this.picker.addClass("datetimepicker-rtl"), this.picker.find(".prev i, .next i").toggleClass("icon-arrow-left icon-arrow-right")),
            a(document).on("mousedown",
            function(b) {
                0 === a(b.target).closest(".datetimepicker").length && f.hide()
            }),
            this.autoclose = !1,
            "autoclose" in c ? this.autoclose = c.autoclose: "dateAutoclose" in this.element.data() && (this.autoclose = this.element.data("date-autoclose")),
            this.keyboardNavigation = !0,
            "keyboardNavigation" in c ? this.keyboardNavigation = c.keyboardNavigation: "dateKeyboardNavigation" in this.element.data() && (this.keyboardNavigation = this.element.data("date-keyboard-navigation")),
            this.todayBtn = c.todayBtn || this.element.data("date-today-btn") || !1,
            this.todayHighlight = c.todayHighlight || this.element.data("date-today-highlight") || !1,
            this.weekStart = (c.weekStart || this.element.data("date-weekstart") || d[this.language].weekStart || 0) % 7,
            this.weekEnd = (this.weekStart + 6) % 7,
            this.startDate = -1 / 0,
            this.endDate = 1 / 0,
            this.daysOfWeekDisabled = [],
            this.setStartDate(c.startDate || this.element.data("date-startdate")),
            this.setEndDate(c.endDate || this.element.data("date-enddate")),
            this.setDaysOfWeekDisabled(c.daysOfWeekDisabled || this.element.data("date-days-of-week-disabled")),
            this.fillDow(),
            this.fillMonths(),
            this.update(),
            this.showMode(),
            this.isInline && this.show()
        };
        c.prototype = {
            constructor: c,
            _events: [],
            _attachEvents: function() {
                this._detachEvents(),
                this.isInput ? this._events = [[this.element, {
                    focus: a.proxy(this.show, this),
                    keyup: a.proxy(this.update, this),
                    keydown: a.proxy(this.keydown, this)
                }]] : this.component && this.hasInput ? (this._events = [[this.element.find("input"), {
                    focus: a.proxy(this.show, this),
                    keyup: a.proxy(this.update, this),
                    keydown: a.proxy(this.keydown, this)
                }], [this.component, {
                    click: a.proxy(this.show, this)
                }]], this.componentReset && this._events.push([this.componentReset, {
                    click: a.proxy(this.reset, this)
                }])) : this.element.is("div") ? this.isInline = !0 : this._events = [[this.element, {
                    click: a.proxy(this.show, this)
                }]];
                for (var b, c, d = 0; d < this._events.length; d++) b = this._events[d][0],
                c = this._events[d][1],
                b.on(c)
            },
            _detachEvents: function() {
                for (var a, b, c = 0; c < this._events.length; c++) a = this._events[c][0],
                b = this._events[c][1],
                a.off(b);
                this._events = []
            },
            show: function(b) {
                this.picker.show(),
                this.height = this.component ? this.component.outerHeight() : this.element.outerHeight(),
                this.forceParse && this.update(),
                this.place(),
                a(window).on("resize", a.proxy(this.place, this)),
                b && (b.stopPropagation(), b.preventDefault()),
                this.isVisible = !0,
                this.element.trigger({
                    type: "show",
                    date: this.date
                })
            },
            hide: function() {
                this.isVisible && (this.isInline || (this.picker.hide(), a(window).off("resize", this.place), this.viewMode = this.startViewMode, this.showMode(), this.isInput || a(document).off("mousedown", this.hide), this.forceParse && (this.isInput && this.element.val() || this.hasInput && this.element.find("input").val()) && this.setValue(), this.isVisible = !1, this.element.trigger({
                    type: "hide",
                    date: this.date
                })))
            },
            remove: function() {
                this._detachEvents(),
                this.picker.remove(),
                delete this.element.data().datetimepicker
            },
            getDate: function() {
                var a = this.getUTCDate();
                return new Date(a.getTime() + 6e4 * a.getTimezoneOffset())
            },
            getUTCDate: function() {
                return this.date
            },
            setDate: function(a) {
                this.setUTCDate(new Date(a.getTime() - 6e4 * a.getTimezoneOffset()))
            },
            setUTCDate: function(a) {
                a >= this.startDate && a <= this.endDate ? (this.date = a, this.setValue(), this.viewDate = this.date, this.fill()) : this.element.trigger({
                    type: "outOfRange",
                    date: a,
                    startDate: this.startDate,
                    endDate: this.endDate
                })
            },
            setFormat: function(a) {
                this.format = e.parseFormat(a, this.formatType);
                var b;
                this.isInput ? b = this.element: this.component && (b = this.element.find("input")),
                b && b.val() && this.setValue()
            },
            setValue: function() {
                var b = this.getFormattedDate();
                this.isInput ? this.element.val(b) : (this.component && this.element.find("input").val(b), this.element.data("date", b)),
                this.linkField && a("#" + this.linkField).val(this.getFormattedDate(this.linkFormat))
            },
            getFormattedDate: function(a) {
                return void 0 == a && (a = this.format),
                e.formatDate(this.date, a, this.language, this.formatType)
            },
            setStartDate: function(a) {
                this.startDate = a || -1 / 0,
                this.startDate !== -1 / 0 && (this.startDate = e.parseDate(this.startDate, this.format, this.language, this.formatType)),
                this.update(),
                this.updateNavArrows()
            },
            setEndDate: function(a) {
                this.endDate = a || 1 / 0,
                1 / 0 !== this.endDate && (this.endDate = e.parseDate(this.endDate, this.format, this.language, this.formatType)),
                this.update(),
                this.updateNavArrows()
            },
            setDaysOfWeekDisabled: function(b) {
                this.daysOfWeekDisabled = b || [],
                a.isArray(this.daysOfWeekDisabled) || (this.daysOfWeekDisabled = this.daysOfWeekDisabled.split(/,\s*/)),
                this.daysOfWeekDisabled = a.map(this.daysOfWeekDisabled,
                function(a) {
                    return parseInt(a, 10)
                }),
                this.update(),
                this.updateNavArrows()
            },
            place: function() {
                if (!this.isInline) {
                    var b, c, d, e = parseInt(this.element.parents().filter(function() {
                        return "auto" != a(this).css("z-index")
                    }).first().css("z-index")) + 10000;
                    this.component ? (b = this.component.offset(), d = b.left, ("bottom-left" == this.pickerPosition || "top-left" == this.pickerPosition) && (d += this.component.outerWidth() - this.picker.outerWidth())) : (b = this.element.offset(), d = b.left),
                    c = "top-left" == this.pickerPosition || "top-right" == this.pickerPosition ? b.top - this.picker.outerHeight() : b.top + this.height,
                    this.picker.css({
                        top: c,
                        left: d,
                        zIndex: e,
                        width:210,//宽度显示不正常，找不到宽度的计算方式于是定义宽度。 2015-9-21
                    })
                }
            },
            update: function() {
                var a, b = !1;
                arguments && arguments.length && ("string" == typeof arguments[0] || arguments[0] instanceof Date) ? (a = arguments[0], b = !0) : a = this.element.data("date") || (this.isInput ? this.element.val() : this.element.find("input").val()) || this.initialDate,
                a || (a = new Date, b = !1),
                this.date = e.parseDate(a, this.format, this.language, this.formatType),
                b && this.setValue(),
                this.viewDate = this.date < this.startDate ? new Date(this.startDate) : this.date > this.endDate ? new Date(this.endDate) : new Date(this.date),
                this.fill()
            },
            fillDow: function() {
                for (var a = this.weekStart,
                b = "<tr>"; a < this.weekStart + 7;) b += '<th class="dow">' + d[this.language].daysMin[a++%7] + "</th>";
                b += "</tr>",
                this.picker.find(".datetimepicker-days thead").append(b)
            },
            fillMonths: function() {
                for (var a = "",
                b = 0; 12 > b;) a += '<span class="month">' + d[this.language].monthsShort[b++] + "</span>";
                this.picker.find(".datetimepicker-months td").html(a)
            },
            fill: function() {
                if (null != this.date && null != this.viewDate) {
                    var c = new Date(this.viewDate),
                    f = c.getUTCFullYear(),
                    g = c.getUTCMonth(),
                    h = c.getUTCDate(),
                    i = c.getUTCHours(),
                    j = c.getUTCMinutes(),
                    k = this.startDate !== -1 / 0 ? this.startDate.getUTCFullYear() : -1 / 0,
                    l = this.startDate !== -1 / 0 ? this.startDate.getUTCMonth() : -1 / 0,
                    m = 1 / 0 !== this.endDate ? this.endDate.getUTCFullYear() : 1 / 0,
                    n = 1 / 0 !== this.endDate ? this.endDate.getUTCMonth() : 1 / 0,
                    o = new b(this.date.getUTCFullYear(), this.date.getUTCMonth(), this.date.getUTCDate()).valueOf(),
                    p = new Date;
                    if (this.picker.find(".datetimepicker-days thead th:eq(1)").text(d[this.language].months[g] + " " + f), "time" == this.formatViewType) {
                        var q = i % 12 ? i % 12 : 12,
                        r = (10 > q ? "0": "") + q,
                        s = (10 > j ? "0": "") + j,
                        t = d[this.language].meridiem[12 > i ? 0 : 1];
                        this.picker.find(".datetimepicker-hours thead th:eq(1)").text(r + ":" + s + " " + t.toUpperCase()),
                        this.picker.find(".datetimepicker-minutes thead th:eq(1)").text(r + ":" + s + " " + t.toUpperCase())
                    } else this.picker.find(".datetimepicker-hours thead th:eq(1)").text(h + " " + d[this.language].months[g] + " " + f),
                    this.picker.find(".datetimepicker-minutes thead th:eq(1)").text(h + " " + d[this.language].months[g] + " " + f);
                    this.picker.find("tfoot th.today").text(d[this.language].today).toggle(this.todayBtn !== !1),
                    this.updateNavArrows(),
                    this.fillMonths();
                    var u = b(f, g - 1, 28, 0, 0, 0, 0),
                    v = e.getDaysInMonth(u.getUTCFullYear(), u.getUTCMonth());
                    u.setUTCDate(v),
                    u.setUTCDate(v - (u.getUTCDay() - this.weekStart + 7) % 7);
                    var w = new Date(u);
                    w.setUTCDate(w.getUTCDate() + 42),
                    w = w.valueOf();
                    for (var x, y = []; u.valueOf() < w;) u.getUTCDay() == this.weekStart && y.push("<tr>"),
                    x = "",
                    u.getUTCFullYear() < f || u.getUTCFullYear() == f && u.getUTCMonth() < g ? x += " old": (u.getUTCFullYear() > f || u.getUTCFullYear() == f && u.getUTCMonth() > g) && (x += " new"),
                    this.todayHighlight && u.getUTCFullYear() == p.getFullYear() && u.getUTCMonth() == p.getMonth() && u.getUTCDate() == p.getDate() && (x += " today"),
                    u.valueOf() == o && (x += " active"),
                    (u.valueOf() + 864e5 <= this.startDate || u.valueOf() > this.endDate || -1 !== a.inArray(u.getUTCDay(), this.daysOfWeekDisabled)) && (x += " disabled"),
                    y.push('<td class="day' + x + '">' + u.getUTCDate() + "</td>"),
                    u.getUTCDay() == this.weekEnd && y.push("</tr>"),
                    u.setUTCDate(u.getUTCDate() + 1);
                    this.picker.find(".datetimepicker-days tbody").empty().append(y.join("")),
                    y = [];
                    for (var z = "",
                    A = "",
                    B = "",
                    C = 0; 24 > C; C++) {
                        var D = b(f, g, h, C);
                        x = "",
                        D.valueOf() + 36e5 <= this.startDate || D.valueOf() > this.endDate ? x += " disabled": i == C && (x += " active"),
                        this.showMeridian && 2 == d[this.language].meridiem.length ? (A = 12 > C ? d[this.language].meridiem[0] : d[this.language].meridiem[1], A != B && ("" != B && y.push("</fieldset>"), y.push('<fieldset class="hour"><legend>' + A.toUpperCase() + "</legend>")), B = A, z = C % 12 ? C % 12 : 12, y.push('<span class="hour' + x + " hour_" + (12 > C ? "am": "pm") + '">' + z + "</span>"), 23 == C && y.push("</fieldset>")) : (z = C + ":00", y.push('<span class="hour' + x + '">' + z + "</span>"))
                    }
                    this.picker.find(".datetimepicker-hours td").html(y.join("")),
                    y = [],
                    z = "",
                    A = "",
                    B = "";
                    for (var C = 0; 60 > C; C += this.minuteStep) {
                        var D = b(f, g, h, i, C, 0);
                        x = "",
                        D.valueOf() < this.startDate || D.valueOf() > this.endDate ? x += " disabled": Math.floor(j / this.minuteStep) == Math.floor(C / this.minuteStep) && (x += " active"),
                        this.showMeridian && 2 == d[this.language].meridiem.length ? (A = 12 > i ? d[this.language].meridiem[0] : d[this.language].meridiem[1], A != B && ("" != B && y.push("</fieldset>"), y.push('<fieldset class="minute"><legend>' + A.toUpperCase() + "</legend>")), B = A, z = i % 12 ? i % 12 : 12, y.push('<span class="minute' + x + '">' + z + ":" + (10 > C ? "0" + C: C) + "</span>"), 59 == C && y.push("</fieldset>")) : (z = C + ":00", y.push('<span class="minute' + x + '">' + i + ":" + (10 > C ? "0" + C: C) + "</span>"))
                    }
                    this.picker.find(".datetimepicker-minutes td").html(y.join(""));
                    var E = this.date.getUTCFullYear(),
                    F = this.picker.find(".datetimepicker-months").find("th:eq(1)").text(f).end().find("span").removeClass("active");
                    E == f && F.eq(this.date.getUTCMonth()).addClass("active"),
                    (k > f || f > m) && F.addClass("disabled"),
                    f == k && F.slice(0, l).addClass("disabled"),
                    f == m && F.slice(n + 1).addClass("disabled"),
                    y = "",
                    f = 10 * parseInt(f / 10, 10);
                    var G = this.picker.find(".datetimepicker-years").find("th:eq(1)").text(f + "-" + (f + 9)).end().find("td");
                    f -= 1;
                    for (var C = -1; 11 > C; C++) y += '<span class="year' + ( - 1 == C || 10 == C ? " old": "") + (E == f ? " active": "") + (k > f || f > m ? " disabled": "") + '">' + f + "</span>",
                    f += 1;
                    G.html(y),
                    this.place()
                }
            },
            updateNavArrows: function() {
                var a = new Date(this.viewDate),
                b = a.getUTCFullYear(),
                c = a.getUTCMonth(),
                d = a.getUTCDate(),
                e = a.getUTCHours();
                switch (this.viewMode) {
                case 0:
                    this.startDate !== -1 / 0 && b <= this.startDate.getUTCFullYear() && c <= this.startDate.getUTCMonth() && d <= this.startDate.getUTCDate() && e <= this.startDate.getUTCHours() ? this.picker.find(".prev").css({
                        visibility: "hidden"
                    }) : this.picker.find(".prev").css({
                        visibility: "visible"
                    }),
                    1 / 0 !== this.endDate && b >= this.endDate.getUTCFullYear() && c >= this.endDate.getUTCMonth() && d >= this.endDate.getUTCDate() && e >= this.endDate.getUTCHours() ? this.picker.find(".next").css({
                        visibility: "hidden"
                    }) : this.picker.find(".next").css({
                        visibility: "visible"
                    });
                    break;
                case 1:
                    this.startDate !== -1 / 0 && b <= this.startDate.getUTCFullYear() && c <= this.startDate.getUTCMonth() && d <= this.startDate.getUTCDate() ? this.picker.find(".prev").css({
                        visibility: "hidden"
                    }) : this.picker.find(".prev").css({
                        visibility: "visible"
                    }),
                    1 / 0 !== this.endDate && b >= this.endDate.getUTCFullYear() && c >= this.endDate.getUTCMonth() && d >= this.endDate.getUTCDate() ? this.picker.find(".next").css({
                        visibility: "hidden"
                    }) : this.picker.find(".next").css({
                        visibility: "visible"
                    });
                    break;
                case 2:
                    this.startDate !== -1 / 0 && b <= this.startDate.getUTCFullYear() && c <= this.startDate.getUTCMonth() ? this.picker.find(".prev").css({
                        visibility: "hidden"
                    }) : this.picker.find(".prev").css({
                        visibility: "visible"
                    }),
                    1 / 0 !== this.endDate && b >= this.endDate.getUTCFullYear() && c >= this.endDate.getUTCMonth() ? this.picker.find(".next").css({
                        visibility: "hidden"
                    }) : this.picker.find(".next").css({
                        visibility: "visible"
                    });
                    break;
                case 3:
                case 4:
                    this.startDate !== -1 / 0 && b <= this.startDate.getUTCFullYear() ? this.picker.find(".prev").css({
                        visibility: "hidden"
                    }) : this.picker.find(".prev").css({
                        visibility: "visible"
                    }),
                    1 / 0 !== this.endDate && b >= this.endDate.getUTCFullYear() ? this.picker.find(".next").css({
                        visibility: "hidden"
                    }) : this.picker.find(".next").css({
                        visibility: "visible"
                    })
                }
            },
            click: function(c) {
                c.stopPropagation(),
                c.preventDefault();
                var d = a(c.target).closest("span, td, th, legend");
                if (1 == d.length) {
                    if (d.is(".disabled")) return this.element.trigger({
                        type: "outOfRange",
                        date: this.viewDate,
                        startDate: this.startDate,
                        endDate: this.endDate
                    }),
                    void 0;
                    switch (d[0].nodeName.toLowerCase()) {
                    case "th":
                        switch (d[0].className) {
                        case "switch":
                            this.showMode(1);
                            break;
                        case "prev":
                        case "next":
                            var f = e.modes[this.viewMode].navStep * ("prev" == d[0].className ? -1 : 1);
                            switch (this.viewMode) {
                            case 0:
                                this.viewDate = this.moveHour(this.viewDate, f);
                                break;
                            case 1:
                                this.viewDate = this.moveDate(this.viewDate, f);
                                break;
                            case 2:
                                this.viewDate = this.moveMonth(this.viewDate, f);
                                break;
                            case 3:
                            case 4:
                                this.viewDate = this.moveYear(this.viewDate, f)
                            }
                            this.fill();
                            break;
                        case "today":
                            var g = new Date;
                            g = b(g.getFullYear(), g.getMonth(), g.getDate(), g.getHours(), g.getMinutes(), g.getSeconds(), 0),
                            this.viewMode = this.startViewMode,
                            this.showMode(0),
                            this._setDate(g),
                            this.fill(),
                            this.autoclose && this.hide()
                        }
                        break;
                    case "span":
                        if (!d.is(".disabled")) {
                            var h = this.viewDate.getUTCFullYear(),
                            i = this.viewDate.getUTCMonth(),
                            j = this.viewDate.getUTCDate(),
                            k = this.viewDate.getUTCHours(),
                            l = this.viewDate.getUTCMinutes(),
                            m = this.viewDate.getUTCSeconds();
                            if (d.is(".month") ? (this.viewDate.setUTCDate(1), i = d.parent().find("span").index(d), j = this.viewDate.getUTCDate(), this.viewDate.setUTCMonth(i), this.element.trigger({
                                type: "changeMonth",
                                date: this.viewDate
                            }), this.viewSelect >= 3 && this._setDate(b(h, i, j, k, l, m, 0))) : d.is(".year") ? (this.viewDate.setUTCDate(1), h = parseInt(d.text(), 10) || 0, this.viewDate.setUTCFullYear(h), this.element.trigger({
                                type: "changeYear",
                                date: this.viewDate
                            }), this.viewSelect >= 4 && this._setDate(b(h, i, j, k, l, m, 0))) : d.is(".hour") ? (k = parseInt(d.text(), 10) || 0, (d.hasClass("hour_am") || d.hasClass("hour_pm")) && (12 == k && d.hasClass("hour_am") ? k = 0 : 12 != k && d.hasClass("hour_pm") && (k += 12)), this.viewDate.setUTCHours(k), this.element.trigger({
                                type: "changeHour",
                                date: this.viewDate
                            }), this.viewSelect >= 1 && this._setDate(b(h, i, j, k, l, m, 0))) : d.is(".minute") && (l = parseInt(d.text().substr(d.text().indexOf(":") + 1), 10) || 0, this.viewDate.setUTCMinutes(l), this.element.trigger({
                                type: "changeMinute",
                                date: this.viewDate
                            }), this.viewSelect >= 0 && this._setDate(b(h, i, j, k, l, m, 0))), 0 != this.viewMode) {
                                var n = this.viewMode;
                                this.showMode( - 1),
                                this.fill(),
                                n == this.viewMode && this.autoclose && this.hide()
                            } else this.fill(),
                            this.autoclose && this.hide()
                        }
                        break;
                    case "td":
                        if (d.is(".day") && !d.is(".disabled")) {
                            var j = parseInt(d.text(), 10) || 1,
                            h = this.viewDate.getUTCFullYear(),
                            i = this.viewDate.getUTCMonth(),
                            k = this.viewDate.getUTCHours(),
                            l = this.viewDate.getUTCMinutes(),
                            m = this.viewDate.getUTCSeconds();
                            d.is(".old") ? 0 === i ? (i = 11, h -= 1) : i -= 1 : d.is(".new") && (11 == i ? (i = 0, h += 1) : i += 1),
                            this.viewDate.setUTCFullYear(h),
                            this.viewDate.setUTCMonth(i),
                            this.viewDate.setUTCDate(j),
                            this.element.trigger({
                                type: "changeDay",
                                date: this.viewDate
                            }),
                            this.viewSelect >= 2 && this._setDate(b(h, i, j, k, l, m, 0))
                        }
                        var n = this.viewMode;
                        this.showMode( - 1),
                        this.fill(),
                        n == this.viewMode && this.autoclose && this.hide()
                    }
                }
            },
            _setDate: function(a, b) {
                b && "date" != b || (this.date = a),
                b && "view" != b || (this.viewDate = a),
                this.fill(),
                this.setValue();
                var c;
                this.isInput ? c = this.element: this.component && (c = this.element.find("input")),
                c && (c.change(), this.autoclose && (!b || "date" == b)),
                this.element.trigger({
                    type: "changeDate",
                    date: this.date
                })
            },
            moveMinute: function(a, b) {
                if (!b) return a;
                var c = new Date(a.valueOf());
                return c.setUTCMinutes(c.getUTCMinutes() + b * this.minuteStep),
                c
            },
            moveHour: function(a, b) {
                if (!b) return a;
                var c = new Date(a.valueOf());
                return c.setUTCHours(c.getUTCHours() + b),
                c
            },
            moveDate: function(a, b) {
                if (!b) return a;
                var c = new Date(a.valueOf());
                return c.setUTCDate(c.getUTCDate() + b),
                c
            },
            moveMonth: function(a, b) {
                if (!b) return a;
                var c, d, e = new Date(a.valueOf()),
                f = e.getUTCDate(),
                g = e.getUTCMonth(),
                h = Math.abs(b);
                if (b = b > 0 ? 1 : -1, 1 == h) d = -1 == b ?
                function() {
                    return e.getUTCMonth() == g
                }: function() {
                    return e.getUTCMonth() != c
                },
                c = g + b,
                e.setUTCMonth(c),
                (0 > c || c > 11) && (c = (c + 12) % 12);
                else {
                    for (var i = 0; h > i; i++) e = this.moveMonth(e, b);
                    c = e.getUTCMonth(),
                    e.setUTCDate(f),
                    d = function() {
                        return c != e.getUTCMonth()
                    }
                }
                for (; d();) e.setUTCDate(--f),
                e.setUTCMonth(c);
                return e
            },
            moveYear: function(a, b) {
                return this.moveMonth(a, 12 * b)
            },
            dateWithinRange: function(a) {
                return a >= this.startDate && a <= this.endDate
            },
            keydown: function(a) {
                if (this.picker.is(":not(:visible)")) return 27 == a.keyCode && this.show(),
                void 0;
                var b, c, d, e = !1;
                switch (a.keyCode) {
                case 27:
                    this.hide(),
                    a.preventDefault();
                    break;
                case 37:
                case 39:
                    if (!this.keyboardNavigation) break;
                    b = 37 == a.keyCode ? -1 : 1,
                    viewMode = this.viewMode,
                    a.ctrlKey ? viewMode += 2 : a.shiftKey && (viewMode += 1),
                    4 == viewMode ? (c = this.moveYear(this.date, b), d = this.moveYear(this.viewDate, b)) : 3 == viewMode ? (c = this.moveMonth(this.date, b), d = this.moveMonth(this.viewDate, b)) : 2 == viewMode ? (c = this.moveDate(this.date, b), d = this.moveDate(this.viewDate, b)) : 1 == viewMode ? (c = this.moveHour(this.date, b), d = this.moveHour(this.viewDate, b)) : 0 == viewMode && (c = this.moveMinute(this.date, b), d = this.moveMinute(this.viewDate, b)),
                    this.dateWithinRange(c) && (this.date = c, this.viewDate = d, this.setValue(), this.update(), a.preventDefault(), e = !0);
                    break;
                case 38:
                case 40:
                    if (!this.keyboardNavigation) break;
                    b = 38 == a.keyCode ? -1 : 1,
                    viewMode = this.viewMode,
                    a.ctrlKey ? viewMode += 2 : a.shiftKey && (viewMode += 1),
                    4 == viewMode ? (c = this.moveYear(this.date, b), d = this.moveYear(this.viewDate, b)) : 3 == viewMode ? (c = this.moveMonth(this.date, b), d = this.moveMonth(this.viewDate, b)) : 2 == viewMode ? (c = this.moveDate(this.date, 7 * b), d = this.moveDate(this.viewDate, 7 * b)) : 1 == viewMode ? this.showMeridian ? (c = this.moveHour(this.date, 6 * b), d = this.moveHour(this.viewDate, 6 * b)) : (c = this.moveHour(this.date, 4 * b), d = this.moveHour(this.viewDate, 4 * b)) : 0 == viewMode && (c = this.moveMinute(this.date, 4 * b), d = this.moveMinute(this.viewDate, 4 * b)),
                    this.dateWithinRange(c) && (this.date = c, this.viewDate = d, this.setValue(), this.update(), a.preventDefault(), e = !0);
                    break;
                case 13:
                    if (0 != this.viewMode) {
                        var f = this.viewMode;
                        this.showMode( - 1),
                        this.fill(),
                        f == this.viewMode && this.autoclose && this.hide()
                    } else this.fill(),
                    this.autoclose && this.hide();
                    a.preventDefault();
                    break;
                case 9:
                    this.hide()
                }
                if (e) {
                    var g;
                    this.isInput ? g = this.element: this.component && (g = this.element.find("input")),
                    g && g.change(),
                    this.element.trigger({
                        type: "changeDate",
                        date: this.date
                    })
                }
            },
            showMode: function(a) {
                if (a) {
                    var b = Math.max(0, Math.min(e.modes.length - 1, this.viewMode + a));
                    b >= this.minView && b <= this.maxView && (this.element.trigger({
                        type: "changeMode",
                        date: this.viewDate,
                        oldViewMode: this.viewMode,
                        newViewMode: b
                    }), this.viewMode = b)
                }
                this.picker.find(">div").hide().filter(".datetimepicker-" + e.modes[this.viewMode].clsName).css("display", "block"),
                this.updateNavArrows()
            },
            reset: function() {
                this._setDate(null, "date")
            }
        },
        a.fn.datetimepicker = function(b) {
            var d = Array.apply(null, arguments);
            return d.shift(),
            this.each(function() {
                var e = a(this),
                f = e.data("datetimepicker"),
                g = "object" == typeof b && b;
                f || e.data("datetimepicker", f = new c(this, a.extend({},
                a.fn.datetimepicker.defaults, g))),
                "string" == typeof b && "function" == typeof f[b] && f[b].apply(f, d)
            })
        },
        a.fn.datetimepicker.defaults = {},
        a.fn.datetimepicker.Constructor = c;
        var d = a.fn.datetimepicker.dates = {
            en: {
                days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
                daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
                daysMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"],
                months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                meridiem: ["am", "pm"],
                suffix: ["st", "nd", "rd", "th"],
                today: "Today"
            }
        },
        e = {
            modes: [{
                clsName: "minutes",
                navFnc: "Hours",
                navStep: 1
            },
            {
                clsName: "hours",
                navFnc: "Date",
                navStep: 1
            },
            {
                clsName: "days",
                navFnc: "Month",
                navStep: 1
            },
            {
                clsName: "months",
                navFnc: "FullYear",
                navStep: 1
            },
            {
                clsName: "years",
                navFnc: "FullYear",
                navStep: 10
            }],
            isLeapYear: function(a) {
                return 0 === a % 4 && 0 !== a % 100 || 0 === a % 400
            },
            getDaysInMonth: function(a, b) {
                return [31, e.isLeapYear(a) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][b]
            },
            getDefaultFormat: function(a, b) {
                if ("standard" == a) return "input" == b ? "yyyy-mm-dd hh:ii": "yyyy-mm-dd hh:ii:ss";
                if ("php" == a) return "input" == b ? "Y-m-d H:i": "Y-m-d H:i:s";
                throw new Error("Invalid format type.")
            },
            validParts: function(a) {
                if ("standard" == a) return /hh?|HH?|p|P|ii?|ss?|dd?|DD?|mm?|MM?|yy(?:yy)?/g;
                if ("php" == a) return /[dDjlNwzFmMnStyYaABgGhHis]/g;
                throw new Error("Invalid format type.")
            },
            nonpunctuation: /[^ -\/:-@\[-`{-~\t\n\rTZ]+/g,
            parseFormat: function(a, b) {
                var c = a.replace(this.validParts(b), "\0").split("\0"),
                d = a.match(this.validParts(b));
                if (!c || !c.length || !d || 0 == d.length) throw new Error("Invalid date format.");
                return {
                    separators: c,
                    parts: d
                }
            },
            parseDate: function(e, f, g, h) {
                if (e instanceof Date) {
                    var i = new Date(e.valueOf() - 6e4 * e.getTimezoneOffset());
                    return i.setMilliseconds(0),
                    i
                }
                if (/^\d{4}\-\d{1,2}\-\d{1,2}$/.test(e) && (f = this.parseFormat("yyyy-mm-dd", h)), /^\d{4}\-\d{1,2}\-\d{1,2}[T ]\d{1,2}\:\d{1,2}$/.test(e) && (f = this.parseFormat("yyyy-mm-dd hh:ii", h)), /^\d{4}\-\d{1,2}\-\d{1,2}[T ]\d{1,2}\:\d{1,2}\:\d{1,2}[Z]{0,1}$/.test(e) && (f = this.parseFormat("yyyy-mm-dd hh:ii:ss", h)), /^[-+]\d+[dmwy]([\s,]+[-+]\d+[dmwy])*$/.test(e)) {
                    var j, k, l = /([-+]\d+)([dmwy])/,
                    m = e.match(/([-+]\d+)([dmwy])/g);
                    e = new Date;
                    for (var n = 0; n < m.length; n++) switch (j = l.exec(m[n]), k = parseInt(j[1]), j[2]) {
                    case "d":
                        e.setUTCDate(e.getUTCDate() + k);
                        break;
                    case "m":
                        e = c.prototype.moveMonth.call(c.prototype, e, k);
                        break;
                    case "w":
                        e.setUTCDate(e.getUTCDate() + 7 * k);
                        break;
                    case "y":
                        e = c.prototype.moveYear.call(c.prototype, e, k)
                    }
                    return b(e.getUTCFullYear(), e.getUTCMonth(), e.getUTCDate(), e.getUTCHours(), e.getUTCMinutes(), e.getUTCSeconds(), 0)
                }
                var o, p, j, m = e && e.match(this.nonpunctuation) || [],
                e = new Date(0, 0, 0, 0, 0, 0, 0),
                q = {},
                r = ["hh", "h", "ii", "i", "ss", "s", "yyyy", "yy", "M", "MM", "m", "mm", "D", "DD", "d", "dd", "H", "HH", "p", "P"],
                s = {
                    hh: function(a, b) {
                        return a.setUTCHours(b)
                    },
                    h: function(a, b) {
                        return a.setUTCHours(b)
                    },
                    HH: function(a, b) {
                        return a.setUTCHours(12 == b ? 0 : b)
                    },
                    H: function(a, b) {
                        return a.setUTCHours(12 == b ? 0 : b)
                    },
                    ii: function(a, b) {
                        return a.setUTCMinutes(b)
                    },
                    i: function(a, b) {
                        return a.setUTCMinutes(b)
                    },
                    ss: function(a, b) {
                        return a.setUTCSeconds(b)
                    },
                    s: function(a, b) {
                        return a.setUTCSeconds(b)
                    },
                    yyyy: function(a, b) {
                        return a.setUTCFullYear(b)
                    },
                    yy: function(a, b) {
                        return a.setUTCFullYear(2e3 + b)
                    },
                    m: function(a, b) {
                        for (b -= 1; 0 > b;) b += 12;
                        for (b %= 12, a.setUTCMonth(b); a.getUTCMonth() != b;) a.setUTCDate(a.getUTCDate() - 1);
                        return a
                    },
                    d: function(a, b) {
                        return a.setUTCDate(b)
                    },
                    p: function(a, b) {
                        return a.setUTCHours(1 == b ? a.getUTCHours() + 12 : a.getUTCHours())
                    }
                };
                if (s.M = s.MM = s.mm = s.m, s.dd = s.d, s.P = s.p, e = b(e.getFullYear(), e.getMonth(), e.getDate(), e.getHours(), e.getMinutes(), e.getSeconds()), m.length == f.parts.length) {
                    for (var n = 0,
                    t = f.parts.length; t > n; n++) {
                        if (o = parseInt(m[n], 10), j = f.parts[n], isNaN(o)) switch (j) {
                        case "MM":
                            p = a(d[g].months).filter(function() {
                                var a = this.slice(0, m[n].length),
                                b = m[n].slice(0, a.length);
                                return a == b
                            }),
                            o = a.inArray(p[0], d[g].months) + 1;
                            break;
                        case "M":
                            p = a(d[g].monthsShort).filter(function() {
                                var a = this.slice(0, m[n].length),
                                b = m[n].slice(0, a.length);
                                return a == b
                            }),
                            o = a.inArray(p[0], d[g].monthsShort) + 1;
                            break;
                        case "p":
                        case "P":
                            o = a.inArray(m[n].toLowerCase(), d[g].meridiem)
                        }
                        q[j] = o
                    }
                    for (var u, n = 0; n < r.length; n++) u = r[n],
                    u in q && !isNaN(q[u]) && s[u](e, q[u])
                }
                return e
            },
            formatDate: function(b, c, f, g) {
                if (null == b) return "";
                var h;
                if ("standard" == g) h = {
                    yy: b.getUTCFullYear().toString().substring(2),
                    yyyy: b.getUTCFullYear(),
                    m: b.getUTCMonth() + 1,
                    M: d[f].monthsShort[b.getUTCMonth()],
                    MM: d[f].months[b.getUTCMonth()],
                    d: b.getUTCDate(),
                    D: d[f].daysShort[b.getUTCDay()],
                    DD: d[f].days[b.getUTCDay()],
                    p: 2 == d[f].meridiem.length ? d[f].meridiem[b.getUTCHours() < 12 ? 0 : 1] : "",
                    h: b.getUTCHours(),
                    i: b.getUTCMinutes(),
                    s: b.getUTCSeconds()
                },
                h.H = 0 == h.h % 12 ? 12 : h.h % 12,
                h.HH = (h.H < 10 ? "0": "") + h.H,
                h.P = h.p.toUpperCase(),
                h.hh = (h.h < 10 ? "0": "") + h.h,
                h.ii = (h.i < 10 ? "0": "") + h.i,
                h.ss = (h.s < 10 ? "0": "") + h.s,
                h.dd = (h.d < 10 ? "0": "") + h.d,
                h.mm = (h.m < 10 ? "0": "") + h.m;
                else {
                    if ("php" != g) throw new Error("Invalid format type.");
                    h = {
                        y: b.getUTCFullYear().toString().substring(2),
                        Y: b.getUTCFullYear(),
                        F: d[f].months[b.getUTCMonth()],
                        M: d[f].monthsShort[b.getUTCMonth()],
                        n: b.getUTCMonth() + 1,
                        t: e.getDaysInMonth(b.getUTCFullYear(), b.getUTCMonth()),
                        j: b.getUTCDate(),
                        l: d[f].days[b.getUTCDay()],
                        D: d[f].daysShort[b.getUTCDay()],
                        w: b.getUTCDay(),
                        N: 0 == b.getUTCDay() ? 7 : b.getUTCDay(),
                        S: b.getUTCDate() % 10 <= d[f].suffix.length ? d[f].suffix[b.getUTCDate() % 10 - 1] : "",
                        a: 2 == d[f].meridiem.length ? d[f].meridiem[b.getUTCHours() < 12 ? 0 : 1] : "",
                        g: 0 == b.getUTCHours() % 12 ? 12 : b.getUTCHours() % 12,
                        G: b.getUTCHours(),
                        i: b.getUTCMinutes(),
                        s: b.getUTCSeconds()
                    },
                    h.m = (h.n < 10 ? "0": "") + h.n,
                    h.d = (h.j < 10 ? "0": "") + h.j,
                    h.A = h.a.toString().toUpperCase(),
                    h.h = (h.g < 10 ? "0": "") + h.g,
                    h.H = (h.G < 10 ? "0": "") + h.G,
                    h.i = (h.i < 10 ? "0": "") + h.i,
                    h.s = (h.s < 10 ? "0": "") + h.s
                }
                for (var b = [], i = a.extend([], c.separators), j = 0, k = c.parts.length; k > j; j++) i.length && b.push(i.shift()),
                b.push(h[c.parts[j]]);
                return b.join("")
            },
            convertViewMode: function(a) {
                switch (a) {
                case 4:
                case "decade":
                    a = 4;
                    break;
                case 3:
                case "year":
                    a = 3;
                    break;
                case 2:
                case "month":
                    a = 2;
                    break;
                case 1:
                case "day":
                    a = 1;
                    break;
                case 0:
                case "hour":
                    a = 0
                }
                return a
            },
            headTemplate: '<thead><tr><th class="prev"><i class="glyphicon glyphicon-chevron-left"/></th><th colspan="5" class="switch"></th><th class="next"><i class="glyphicon glyphicon-chevron-right"/></th></tr></thead>',
            contTemplate: '<tbody><tr><td colspan="7"></td></tr></tbody>',
            footTemplate: '<tfoot><tr><th colspan="7" class="today"></th></tr></tfoot>'
        };
        e.template = '<div class="datetimepicker"><div class="datetimepicker-minutes"><table class=" table-condensed">' + e.headTemplate + e.contTemplate + e.footTemplate + "</table>" + "</div>" + '<div class="datetimepicker-hours">' + '<table class=" table-condensed">' + e.headTemplate + e.contTemplate + e.footTemplate + "</table>" + "</div>" + '<div class="datetimepicker-days">' + '<table class=" table-condensed">' + e.headTemplate + "<tbody></tbody>" + e.footTemplate + "</table>" + "</div>" + '<div class="datetimepicker-months">' + '<table class="table-condensed">' + e.headTemplate + e.contTemplate + e.footTemplate + "</table>" + "</div>" + '<div class="datetimepicker-years">' + '<table class="table-condensed">' + e.headTemplate + e.contTemplate + e.footTemplate + "</table>" + "</div>" + "</div>",
        a.fn.datetimepicker.DPGlobal = e,
        a.fn.datetimepicker.noConflict = function() {
            return a.fn.datetimepicker = old,
            this
        },
        a(document).on("focus.datetimepicker.data-api click.datetimepicker.data-api", '[data-provide="datetimepicker"]',
        function(b) {
            var c = a(this);
            c.data("datetimepicker") || (b.preventDefault(), c.datetimepicker("show"))
        }),
        a(function() {
            a('[data-provide="datetimepicker-inline"]').datetimepicker()
        })
    } (window.jQuery),
    a("./i18n/{locale}")
}),
define("jquery-plugin/bootstrap-datetimepicker/1.0.0/datetimepicker.css", [],
function() {
    seajs.importStyle(".datetimepicker{padding:4px;margin-top:1px;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px;direction:ltr}.datetimepicker-inline{width:220px}.datetimepicker.datetimepicker-rtl{direction:rtl}.datetimepicker.datetimepicker-rtl table tr td span{float:right}.datetimepicker-dropdown,.datetimepicker-dropdown-left{top:0;left:0}[class*=\" datetimepicker-dropdown\"]:before{content:'';display:inline-block;border-left:7px solid transparent;border-right:7px solid transparent;border-bottom:7px solid #ccc;border-bottom-color:rgba(0,0,0,.2);position:absolute}[class*=\" datetimepicker-dropdown\"]:after{content:'';display:inline-block;border-left:6px solid transparent;border-right:6px solid transparent;border-bottom:6px solid #fff;position:absolute}[class*=\" datetimepicker-dropdown-top\"]:before{content:'';display:inline-block;border-left:7px solid transparent;border-right:7px solid transparent;border-top:7px solid #ccc;border-top-color:rgba(0,0,0,.2);border-bottom:0}[class*=\" datetimepicker-dropdown-top\"]:after{content:'';display:inline-block;border-left:6px solid transparent;border-right:6px solid transparent;border-top:6px solid #fff;border-bottom:0}.datetimepicker-dropdown-bottom-left:before{top:-7px;right:6px}.datetimepicker-dropdown-bottom-left:after{top:-6px;right:7px}.datetimepicker-dropdown-bottom-right:before{top:-7px;left:6px}.datetimepicker-dropdown-bottom-right:after{top:-6px;left:7px}.datetimepicker-dropdown-top-left:before{bottom:-7px;right:6px}.datetimepicker-dropdown-top-left:after{bottom:-6px;right:7px}.datetimepicker-dropdown-top-right:before{bottom:-7px;left:6px}.datetimepicker-dropdown-top-right:after{bottom:-6px;left:7px}.datetimepicker>div{display:none}.datetimepicker.minutes div.datetimepicker-minutes{display:block}.datetimepicker.hours div.datetimepicker-hours{display:block}.datetimepicker.days div.datetimepicker-days{display:block}.datetimepicker.months div.datetimepicker-months{display:block}.datetimepicker.years div.datetimepicker-years{display:block}.datetimepicker table{margin:0}.datetimepicker td,.datetimepicker th{text-align:center;width:20px;height:20px;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px;border:0}.table-striped .datetimepicker table tr td,.table-striped .datetimepicker table tr th{background-color:transparent}.datetimepicker table tr td.minute:hover{background:#eee;cursor:pointer}.datetimepicker table tr td.hour:hover{background:#eee;cursor:pointer}.datetimepicker table tr td.day:hover{background:#eee;cursor:pointer}.datetimepicker table tr td.old,.datetimepicker table tr td.new{color:#999}.datetimepicker table tr td.disabled,.datetimepicker table tr td.disabled:hover{background:0;color:#999;cursor:default}.datetimepicker table tr td.today,.datetimepicker table tr td.today:hover,.datetimepicker table tr td.today.disabled,.datetimepicker table tr td.today.disabled:hover{background-color:#fde19a;background-image:-moz-linear-gradient(top,#fdd49a,#fdf59a);background-image:-ms-linear-gradient(top,#fdd49a,#fdf59a);background-image:-webkit-gradient(linear,0 0,0 100%,from(#fdd49a),to(#fdf59a));background-image:-webkit-linear-gradient(top,#fdd49a,#fdf59a);background-image:-o-linear-gradient(top,#fdd49a,#fdf59a);background-image:linear-gradient(top,#fdd49a,#fdf59a);background-repeat:repeat-x;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fdd49a', endColorstr='#fdf59a', GradientType=0);border-color:#fdf59a #fdf59a #fbed50;border-color:rgba(0,0,0,.1) rgba(0,0,0,.1) rgba(0,0,0,.25);filter:progid:DXImageTransform.Microsoft.gradient(enabled=false)}.datetimepicker table tr td.today:hover,.datetimepicker table tr td.today:hover:hover,.datetimepicker table tr td.today.disabled:hover,.datetimepicker table tr td.today.disabled:hover:hover,.datetimepicker table tr td.today:active,.datetimepicker table tr td.today:hover:active,.datetimepicker table tr td.today.disabled:active,.datetimepicker table tr td.today.disabled:hover:active,.datetimepicker table tr td.today.active,.datetimepicker table tr td.today:hover.active,.datetimepicker table tr td.today.disabled.active,.datetimepicker table tr td.today.disabled:hover.active,.datetimepicker table tr td.today.disabled,.datetimepicker table tr td.today:hover.disabled,.datetimepicker table tr td.today.disabled.disabled,.datetimepicker table tr td.today.disabled:hover.disabled,.datetimepicker table tr td.today[disabled],.datetimepicker table tr td.today:hover[disabled],.datetimepicker table tr td.today.disabled[disabled],.datetimepicker table tr td.today.disabled:hover[disabled]{background-color:#fdf59a}.datetimepicker table tr td.today:active,.datetimepicker table tr td.today:hover:active,.datetimepicker table tr td.today.disabled:active,.datetimepicker table tr td.today.disabled:hover:active,.datetimepicker table tr td.today.active,.datetimepicker table tr td.today:hover.active,.datetimepicker table tr td.today.disabled.active,.datetimepicker table tr td.today.disabled:hover.active{background-color:#fbf069 \\9}.datetimepicker table tr td.active,.datetimepicker table tr td.active:hover,.datetimepicker table tr td.active.disabled,.datetimepicker table tr td.active.disabled:hover{background-color:#006dcc;background-image:-moz-linear-gradient(top,#08c,#04c);background-image:-ms-linear-gradient(top,#08c,#04c);background-image:-webkit-gradient(linear,0 0,0 100%,from(#08c),to(#04c));background-image:-webkit-linear-gradient(top,#08c,#04c);background-image:-o-linear-gradient(top,#08c,#04c);background-image:linear-gradient(top,#08c,#04c);background-repeat:repeat-x;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0088cc', endColorstr='#0044cc', GradientType=0);border-color:#04c #04c #002a80;border-color:rgba(0,0,0,.1) rgba(0,0,0,.1) rgba(0,0,0,.25);filter:progid:DXImageTransform.Microsoft.gradient(enabled=false);color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,.25)}.datetimepicker table tr td.active:hover,.datetimepicker table tr td.active:hover:hover,.datetimepicker table tr td.active.disabled:hover,.datetimepicker table tr td.active.disabled:hover:hover,.datetimepicker table tr td.active:active,.datetimepicker table tr td.active:hover:active,.datetimepicker table tr td.active.disabled:active,.datetimepicker table tr td.active.disabled:hover:active,.datetimepicker table tr td.active.active,.datetimepicker table tr td.active:hover.active,.datetimepicker table tr td.active.disabled.active,.datetimepicker table tr td.active.disabled:hover.active,.datetimepicker table tr td.active.disabled,.datetimepicker table tr td.active:hover.disabled,.datetimepicker table tr td.active.disabled.disabled,.datetimepicker table tr td.active.disabled:hover.disabled,.datetimepicker table tr td.active[disabled],.datetimepicker table tr td.active:hover[disabled],.datetimepicker table tr td.active.disabled[disabled],.datetimepicker table tr td.active.disabled:hover[disabled]{background-color:#04c}.datetimepicker table tr td.active:active,.datetimepicker table tr td.active:hover:active,.datetimepicker table tr td.active.disabled:active,.datetimepicker table tr td.active.disabled:hover:active,.datetimepicker table tr td.active.active,.datetimepicker table tr td.active:hover.active,.datetimepicker table tr td.active.disabled.active,.datetimepicker table tr td.active.disabled:hover.active{background-color:#039 \\9}.datetimepicker table tr td span{display:block;width:23%;height:54px;line-height:54px;float:left;margin:1%;cursor:pointer;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}.datetimepicker .datetimepicker-hours span{height:26px;line-height:26px}.datetimepicker .datetimepicker-hours table tr td span.hour_am,.datetimepicker .datetimepicker-hours table tr td span.hour_pm{width:14.6%}.datetimepicker .datetimepicker-hours fieldset legend,.datetimepicker .datetimepicker-minutes fieldset legend{margin-bottom:inherit;line-height:30px}.datetimepicker .datetimepicker-minutes span{height:26px;line-height:26px}.datetimepicker table tr td span:hover{background:#eee}.datetimepicker table tr td span.disabled,.datetimepicker table tr td span.disabled:hover{background:0;color:#999;cursor:default}.datetimepicker table tr td span.active,.datetimepicker table tr td span.active:hover,.datetimepicker table tr td span.active.disabled,.datetimepicker table tr td span.active.disabled:hover{background-color:#006dcc;background-image:-moz-linear-gradient(top,#08c,#04c);background-image:-ms-linear-gradient(top,#08c,#04c);background-image:-webkit-gradient(linear,0 0,0 100%,from(#08c),to(#04c));background-image:-webkit-linear-gradient(top,#08c,#04c);background-image:-o-linear-gradient(top,#08c,#04c);background-image:linear-gradient(top,#08c,#04c);background-repeat:repeat-x;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0088cc', endColorstr='#0044cc', GradientType=0);border-color:#04c #04c #002a80;border-color:rgba(0,0,0,.1) rgba(0,0,0,.1) rgba(0,0,0,.25);filter:progid:DXImageTransform.Microsoft.gradient(enabled=false);color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,.25)}.datetimepicker table tr td span.active:hover,.datetimepicker table tr td span.active:hover:hover,.datetimepicker table tr td span.active.disabled:hover,.datetimepicker table tr td span.active.disabled:hover:hover,.datetimepicker table tr td span.active:active,.datetimepicker table tr td span.active:hover:active,.datetimepicker table tr td span.active.disabled:active,.datetimepicker table tr td span.active.disabled:hover:active,.datetimepicker table tr td span.active.active,.datetimepicker table tr td span.active:hover.active,.datetimepicker table tr td span.active.disabled.active,.datetimepicker table tr td span.active.disabled:hover.active,.datetimepicker table tr td span.active.disabled,.datetimepicker table tr td span.active:hover.disabled,.datetimepicker table tr td span.active.disabled.disabled,.datetimepicker table tr td span.active.disabled:hover.disabled,.datetimepicker table tr td span.active[disabled],.datetimepicker table tr td span.active:hover[disabled],.datetimepicker table tr td span.active.disabled[disabled],.datetimepicker table tr td span.active.disabled:hover[disabled]{background-color:#04c}.datetimepicker table tr td span.active:active,.datetimepicker table tr td span.active:hover:active,.datetimepicker table tr td span.active.disabled:active,.datetimepicker table tr td span.active.disabled:hover:active,.datetimepicker table tr td span.active.active,.datetimepicker table tr td span.active:hover.active,.datetimepicker table tr td span.active.disabled.active,.datetimepicker table tr td span.active.disabled:hover.active{background-color:#039 \\9}.datetimepicker table tr td span.old{color:#999}.datetimepicker th.switch{width:145px}.datetimepicker thead tr:first-child th,.datetimepicker tfoot tr:first-child th{cursor:pointer}.datetimepicker thead tr:first-child th:hover,.datetimepicker tfoot tr:first-child th:hover{background:#eee}.input-append.date .add-on i,.input-prepend.date .add-on i{cursor:pointer;width:14px;height:14px}")
});
