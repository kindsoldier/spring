AC_INIT(lorem,0.0.1)
AM_INIT_AUTOMAKE
AC_PREFIX_DEFAULT(/usr/local)

PACKAGE=lorem

AC_CHECK_PROG(HAVE_CP, cp, true, false, /bin /usr/local/bin /usr/bin)
if test "x$HAVE_CP" = "xfalse"; then
	AC_MSG_ERROR([Requested program cp not found])
fi
AC_PATH_PROG([CP],[cp])
AC_PROG_INSTALL
AC_CANONICAL_HOST

case $host_os in
    *freebsd* )
	AC_SUBST(ROOT_GROUP, "wheel")
	AM_CONDITIONAL(FREEBSD_OS, true)
	AM_CONDITIONAL(LINUX_OS, false)
	OSNAME=freebsd
	ROOT_GROUP=wheel
        ;;
    *linux* )
	AC_SUBST(ROOT_GROUP, "root")
	AM_CONDITIONAL(FREEBSD_OS, false)
	AM_CONDITIONAL(LINUX_OS, true)
	OSNAME=linux
	ROOT_GROUP=root
        ;;
esac

AM_CONDITIONAL(SYSTEMD, false)
if test -d /lib/systemd/system; then
	AM_CONDITIONAL(SYSTEMD, true)
fi

AC_ARG_ENABLE([devel-mode], AS_HELP_STRING([--enable-devel-mode], [Enable developmend mode]))

AS_IF([test "x$enable_devel_mode" = "xyes"], [
    SRCDIR=`pwd`
    enable_devel_mode=yes
    AM_CONDITIONAL(DEVEL_MODE, true)
], [
    AM_CONDITIONAL(DEVEL_MODE, false)
])

test "x$prefix" == "xNONE" && prefix=$ac_default_prefix
PREFIX=$prefix


AC_CHECK_PROG(HAVE_JAVA, java, true, false, /bin /usr/local/bin /usr/bin)
if test "x$HAVE_JAVA" = "xfalse"; then
	AC_MSG_ERROR([Requested program java not found])
fi
AC_PATH_PROG([java],[java])
AC_PATH_PROG([JAVA],[java])


AC_CHECK_PROG(HAVE_DAEMON, daemon, true, false, /bin /sbin /usr/bin /usr/sbin /usr/local/sbin /usr/local/bin )
if test "x$HAVE_DAEMON" = "xfalse"; then
	AC_MSG_ERROR([Requested program daemon not found])
fi
AC_PATH_PROG([daemon],[daemon])
AC_PATH_PROG([DAEMON],[daemon])


AS_IF([test "x$enable_devel_mode" = "xyes"], [

    AC_CHECK_PROG(HAVE_GRADLE, gradle, true, false, /bin /usr/local/bin /usr/bin)
    if test "x$HAVE_GRADLE" = "xfalse"; then
	AC_MSG_ERROR([Requested program gradle not found])
    fi
    AC_PATH_PROG([GRADLE],[gradle])
    AC_PATH_PROG([gradle],[gradle])
    AM_CONDITIONAL(HAVE_GRADLE, true)


    AC_CHECK_PROG(HAVE_NPM, npm, true, false, /bin /usr/local/bin /usr/bin)
    if test "x$HAVE_NPM" = "xfalse"; then
	AC_MSG_ERROR([Requested program npm not found])
    fi

    AC_PATH_PROG([NPM],[npm])
    AC_PATH_PROG([npm],[npm])
    AM_CONDITIONAL(HAVE_NPM, true)


    AC_CHECK_PROG(HAVE_SQLITE3, sqlite3, true, false, /bin /usr/local/bin /usr/bin)
    if test "x$HAVE_SQLITE3" = "xfalse"; then
	AC_MSG_ERROR([Requested program sqlite3 not found])
    fi
    AC_PATH_PROG([SQLITE3],[sqlite3])
    AC_PATH_PROG([sqlite3],[sqlite3])
    AM_CONDITIONAL(HAVE_SQLITE3, true)
],
[
    AM_CONDITIONAL(HAVE_GRADLE, false)
    AM_CONDITIONAL(HAVE_NPM, false)
    AM_CONDITIONAL(HAVE_SQLITE3, false)

])

dnl --------------------------------------------------------------------------------------
AC_ARG_WITH(logdir,
	AS_HELP_STRING([--with-logdir=PATH],[set file path for source logdir (default: /var/log/${PACKAGE}/${PACKAGE}.log)]),
	[ if test ! -z "$with_logdir" ; then
		case $with_logdir in
			/*)
				APP_LOGDIR="$with_logdir"
				;;
			*)
                                AC_MSG_ERROR(You must specify an absolute path to --with-logdir=PATH)
				;;
		esac
	else
		APP_LOGDIR="/var/log/${PACKAGE}"
	fi ],
	[ 
	APP_LOGDIR="/var/log/${PACKAGE}"
	])

AS_IF([test "x$enable_devel_mode" = "xyes"], [
	APP_LOGDIR="${SRCDIR}/log"
])

AC_MSG_NOTICE(app_logdir set as ${APP_LOGDIR})

AC_DEFINE_UNQUOTED(APP_LOGDIR, "$APP_LOGDIR", [location of ${PACKAGE} logdir])
AC_SUBST(APP_LOGDIR, "$APP_LOGDIR")

AC_DEFINE_UNQUOTED(app_logdir, "$APP_LOGDIR", [location of ${PACKAGE} logdir])
AC_SUBST(app_logdir, "$APP_LOGDIR")

dnl --------------------------------------------------------------------------------------
AC_ARG_WITH(rundir,
	AS_HELP_STRING([--with-rundir=PATH],[set file path for source rundir (default: /var/run/${PACKAGE})]),
	[ if test ! -z "$with_rundir" ; then
		case $with_rundir in
			/*)
				APP_RUNDIR="$with_rundir"
				;;
			*)
                                AC_MSG_ERROR(You must specify an absolute path to --with-rundir=PATH)
				;;
		esac
	else
		APP_RUNDIR="/var/run/${PACKAGE}"
	fi ],
	[
	APP_RUNDIR="/var/run/${PACKAGE}"
	])

AS_IF([test "x$enable_devel_mode" = "xyes"], [
	APP_RUNDIR="${SRCDIR}/run"
])

AC_MSG_NOTICE(app_rundir set as ${APP_RUNDIR})

AC_DEFINE_UNQUOTED(APP_RUNDIR, "$APP_RUNDIR", [location of pid file])
AC_SUBST(APP_RUNDIR, "$APP_RUNDIR")

AC_DEFINE_UNQUOTED(app_rundir, "$APP_RUNDIR", [location of pid file])
AC_SUBST(app_rundir, "$APP_RUNDIR")

dnl --------------------------------------------------------------------------------------

default_databasedir="/var/db/$PACKAGE"

AC_ARG_WITH(databasedir,
	AS_HELP_STRING([--with-databasedir=PATH],[set data directory (default: $default_databasedir)]),
	[ if test ! -z "$with_databasedir" ; then
		case $with_databasedir in
			/*)
				APP_DATABASEDIR="$with_databasedir"
				;;
			*)
                                AC_MSG_ERROR(You must specify an absolute path to --with-databasedir=PATH)
				;;
		esac
	else
		APP_DATABASEDIR="$default_databasedir"
	fi ],
	[
	APP_DATABASEDIR="$default_databasedir"
	])

AS_IF([test "x$enable_devel_mode" = "xyes"], [
	APP_DATABASEDIR="${SRCDIR}/"
])

AC_MSG_RESULT(databasedir set as ${APP_DATABASEDIR})


AC_DEFINE_UNQUOTED(APP_DATABASEDIR, "$APP_DATABASEDIR", [location of database dir])
AC_SUBST(APP_DATABASEDIR, "$APP_DATABASEDIR")

AC_DEFINE_UNQUOTED(app_databasedir, "$APP_DATABASEDIR", [location of database dir])
AC_SUBST(app_databasedir, "$APP_DATABASEDIR")


dnl --------------------------------------------------------------------------------------

AC_ARG_WITH(libdir,
	AS_HELP_STRING([--with-libdir=PATH],[set file path for source libdir (default: ${PREFIX}/share/${PACKAGE})]),
	[ if test ! -z "$with_libdir" ; then
		case $with_libdir in
			/*)
				APP_LIBDIR="$with_libdir"
				;;
			*)
                                AC_MSG_ERROR(You must specify an absolute path to --with-libdir=PATH)
				;;
		esac
	else
		APP_LIBDIR="${PREFIX}/lib/${PACKAGE}"
	fi ],
	[
	    APP_LIBDIR="${PREFIX}/lib/${PACKAGE}"
	])

AS_IF([test "x$enable_devel_mode" = "xyes"], [
	APP_LIBDIR="${SRCDIR}/"
])

AC_MSG_NOTICE(app_libdir set as ${APP_LIBDIR})

AC_DEFINE_UNQUOTED(APP_LIBDIR, "$APP_LIBDIR", [location of libs])
AC_SUBST(APP_LIBDIR, "$APP_LIBDIR")

AC_DEFINE_UNQUOTED(app_libdir, "$APP_LIBDIR", [location of libs])
AC_SUBST(app_libdir, "$APP_LIBDIR")

dnl --------------------------------------------------------------------------------------

dnl APP_DAEMONIZE="true"
dnl AS_IF([test "x$enable_devel_mode" = "xyes"], [
dnl 	APP_DAEMONIZE="false"
dnl ])

dnl AC_SUBST(app_daemonize, "$APP_DAEMONIZE")

AC_OUTPUT([
    Makefile
    lorem
    src/main/resources/application.properties
])
dnl EOF
