/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
<<<<<<< HEAD
 * Copyright (c) 2018-2019, Hunter WB <hunterwb.com>
 * Copyright (c) 2019, Abex
=======
>>>>>>> initial import of runelite
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache.script;

import java.util.HashMap;
import java.util.Map;
import static net.runelite.cache.script.Opcodes.*;

public class Instructions
{
	private final Map<Integer, Instruction> instructions = new HashMap<>();
	private final Map<String, Instruction> instructionsByName = new HashMap<>();

	public void init()
	{
<<<<<<< HEAD
		add(ICONST, "iconst");
		add(GET_VARP, "get_varp");
		add(SET_VARP, "set_varp");
		add(SCONST, "sconst");
		add(JUMP, "jump");
		add(IF_ICMPNE, "if_icmpne");
		add(IF_ICMPEQ, "if_icmpeq");
		add(IF_ICMPLT, "if_icmplt");
		add(IF_ICMPGT, "if_icmpgt");
		add(RETURN, "return");
		add(GET_VARBIT, "get_varbit");
		add(SET_VARBIT, "set_varbit");
		add(IF_ICMPLE, "if_icmple");
		add(IF_ICMPGE, "if_icmpge");
		add(ILOAD, "iload");
		add(ISTORE, "istore");
		add(SLOAD, "sload");
		add(SSTORE, "sstore");
		add(JOIN_STRING, "join_string");
		add(POP_INT, "pop_int");
		add(POP_STRING, "pop_string");
		add(INVOKE, "invoke");
		add(GET_VARC_INT, "get_varc_int");
		add(SET_VARC_INT, "set_varc_int");
		add(DEFINE_ARRAY, "define_array");
		add(GET_ARRAY_INT, "get_array_int");
		add(SET_ARRAY_INT, "set_array_int");
		add(GET_VARC_STRING_OLD, "get_varc_string_old");
		add(SET_VARC_STRING_OLD, "set_varc_string_old");
		add(GET_VARC_STRING, "get_varc_string");
		add(SET_VARC_STRING, "set_varc_string");
		add(SWITCH, "switch");
		add(CC_CREATE, "cc_create");
		add(CC_DELETE, "cc_delete");
		add(CC_DELETEALL, "cc_deleteall");
		add(CC_FIND, "cc_find");
		add(IF_FIND, "if_find");
		add(CC_SETPOSITION, "cc_setposition");
		add(CC_SETSIZE, "cc_setsize");
		add(CC_SETHIDE, "cc_sethide");
		add(CC_SETNOCLICKTHROUGH, "cc_setnoclickthrough");
		add(CC_SETSCROLLPOS, "cc_setscrollpos");
		add(CC_SETCOLOUR, "cc_setcolour");
		add(CC_SETFILL, "cc_setfill");
		add(CC_SETTRANS, "cc_settrans");
		add(CC_SETLINEWID, "cc_setlinewid");
		add(CC_SETGRAPHIC, "cc_setgraphic");
		add(CC_SET2DANGLE, "cc_set2dangle");
		add(CC_SETTILING, "cc_settiling");
		add(CC_SETMODEL, "cc_setmodel");
		add(CC_SETMODELANGLE, "cc_setmodelangle");
		add(CC_SETMODELANIM, "cc_setmodelanim");
		add(CC_SETMODELORTHOG, "cc_setmodelorthog");
		add(CC_SETTEXT, "cc_settext");
		add(CC_SETTEXTFONT, "cc_settextfont");
		add(CC_SETTEXTALIGN, "cc_settextalign");
		add(CC_SETTEXTSHADOW, "cc_settextshadow");
		add(CC_SETOUTLINE, "cc_setoutline");
		add(CC_SETGRAPHICSHADOW, "cc_setgraphicshadow");
		add(CC_SETVFLIP, "cc_setvflip");
		add(CC_SETHFLIP, "cc_sethflip");
		add(CC_SETSCROLLSIZE, "cc_setscrollsize");
		add(CC_RESUME_PAUSEBUTTON, "cc_resume_pausebutton");
		add(CC_SETFILLCOLOUR, "cc_setfillcolour");
		add(CC_SETLINEDIRECTION, "cc_setlinedirection");
		add(CC_SETOBJECT, "cc_setobject");
		add(CC_SETNPCHEAD, "cc_setnpchead");
		add(CC_SETPLAYERHEAD_SELF, "cc_setplayerhead_self");
		add(CC_SETOBJECT_NONUM, "cc_setobject_nonum");
		add(CC_SETOBJECT_ALWAYS_NUM, "cc_setobject_always_num");
		add(CC_SETOP, "cc_setop");
		add(CC_SETDRAGGABLE, "cc_setdraggable");
		add(CC_SETDRAGGABLEBEHAVIOR, "cc_setdraggablebehavior");
		add(CC_SETDRAGDEADZONE, "cc_setdragdeadzone");
		add(CC_SETDRAGDEADTIME, "cc_setdragdeadtime");
		add(CC_SETOPBASE, "cc_setopbase");
		add(CC_SETTARGETVERB, "cc_settargetverb");
		add(CC_CLEAROPS, "cc_clearops");
		add(CC_SETONCLICK, "cc_setonclick");
		add(CC_SETONHOLD, "cc_setonhold");
		add(CC_SETONRELEASE, "cc_setonrelease");
		add(CC_SETONMOUSEOVER, "cc_setonmouseover");
		add(CC_SETONMOUSELEAVE, "cc_setonmouseleave");
		add(CC_SETONDRAG, "cc_setondrag");
		add(CC_SETONTARGETLEAVE, "cc_setontargetleave");
		add(CC_SETONVARTRANSMIT, "cc_setonvartransmit");
		add(CC_SETONTIMER, "cc_setontimer");
		add(CC_SETONOP, "cc_setonop");
		add(CC_SETONDRAGCOMPLETE, "cc_setondragcomplete");
		add(CC_SETONCLICKREPEAT, "cc_setonclickrepeat");
		add(CC_SETONMOUSEREPEAT, "cc_setonmouserepeat");
		add(CC_SETONINVTRANSMIT, "cc_setoninvtransmit");
		add(CC_SETONSTATTRANSMIT, "cc_setonstattransmit");
		add(CC_SETONTARGETENTER, "cc_setontargetenter");
		add(CC_SETONSCROLLWHEEL, "cc_setonscrollwheel");
		add(CC_SETONCHATTRANSMIT, "cc_setonchattransmit");
		add(CC_SETONKEY, "cc_setonkey");
		add(CC_SETONFRIENDTRANSMIT, "cc_setonfriendtransmit");
		add(CC_SETONCLANTRANSMIT, "cc_setonclantransmit");
		add(CC_SETONMISCTRANSMIT, "cc_setonmisctransmit");
		add(CC_SETONDIALOGABORT, "cc_setondialogabort");
		add(CC_SETONSUBCHANGE, "cc_setonsubchange");
		add(CC_SETONSTOCKTRANSMIT, "cc_setonstocktransmit");
		add(CC_SETONRESIZE, "cc_setonresize");
		add(CC_GETX, "cc_getx");
		add(CC_GETY, "cc_gety");
		add(CC_GETWIDTH, "cc_getwidth");
		add(CC_GETHEIGHT, "cc_getheight");
		add(CC_GETHIDE, "cc_gethide");
		add(CC_GETLAYER, "cc_getlayer");
		add(CC_GETSCROLLX, "cc_getscrollx");
		add(CC_GETSCROLLY, "cc_getscrolly");
		add(CC_GETTEXT, "cc_gettext");
		add(CC_GETSCROLLWIDTH, "cc_getscrollwidth");
		add(CC_GETSCROLLHEIGHT, "cc_getscrollheight");
		add(CC_GETMODELZOOM, "cc_getmodelzoom");
		add(CC_GETMODELANGLE_X, "cc_getmodelangle_x");
		add(CC_GETMODELANGLE_Z, "cc_getmodelangle_z");
		add(CC_GETMODELANGLE_Y, "cc_getmodelangle_y");
		add(CC_GETTRANS, "cc_gettrans");
		add(CC_GETCOLOUR, "cc_getcolour");
		add(CC_GETFILLCOLOUR, "cc_getfillcolour");
		add(CC_GETINVOBJECT, "cc_getinvobject");
		add(CC_GETINVCOUNT, "cc_getinvcount");
		add(CC_GETID, "cc_getid");
		add(CC_GETTARGETMASK, "cc_gettargetmask");
		add(CC_GETOP, "cc_getop");
		add(CC_GETOPBASE, "cc_getopbase");
		add(CC_CALLONRESIZE, "cc_callonresize");
		add(IF_SETPOSITION, "if_setposition");
		add(IF_SETSIZE, "if_setsize");
		add(IF_SETHIDE, "if_sethide");
		add(IF_SETNOCLICKTHROUGH, "if_setnoclickthrough");
		add(IF_SETSCROLLPOS, "if_setscrollpos");
		add(IF_SETCOLOUR, "if_setcolour");
		add(IF_SETFILL, "if_setfill");
		add(IF_SETTRANS, "if_settrans");
		add(IF_SETLINEWID, "if_setlinewid");
		add(IF_SETGRAPHIC, "if_setgraphic");
		add(IF_SET2DANGLE, "if_set2dangle");
		add(IF_SETTILING, "if_settiling");
		add(IF_SETMODEL, "if_setmodel");
		add(IF_SETMODELANGLE, "if_setmodelangle");
		add(IF_SETMODELANIM, "if_setmodelanim");
		add(IF_SETMODELORTHOG, "if_setmodelorthog");
		add(IF_SETTEXT, "if_settext");
		add(IF_SETTEXTFONT, "if_settextfont");
		add(IF_SETTEXTALIGN, "if_settextalign");
		add(IF_SETTEXTSHADOW, "if_settextshadow");
		add(IF_SETOUTLINE, "if_setoutline");
		add(IF_SETGRAPHICSHADOW, "if_setgraphicshadow");
		add(IF_SETVFLIP, "if_setvflip");
		add(IF_SETHFLIP, "if_sethflip");
		add(IF_SETSCROLLSIZE, "if_setscrollsize");
		add(IF_RESUME_PAUSEBUTTON, "if_resume_pausebutton");
		add(IF_SETFILLCOLOUR, "if_setfillcolour");
		add(IF_SETLINEDIRECTION, "if_setlinedirection");
		add(IF_SETOBJECT, "if_setobject");
		add(IF_SETNPCHEAD, "if_setnpchead");
		add(IF_SETPLAYERHEAD_SELF, "if_setplayerhead_self");
		add(IF_SETOBJECT_NONUM, "if_setobject_nonum");
		add(IF_SETOBJECT_ALWAYS_NUM, "if_setobject_always_num");
		add(IF_SETOP, "if_setop");
		add(IF_SETDRAGGABLE, "if_setdraggable");
		add(IF_SETDRAGGABLEBEHAVIOR, "if_setdraggablebehavior");
		add(IF_SETDRAGDEADZONE, "if_setdragdeadzone");
		add(IF_SETDRAGDEADTIME, "if_setdragdeadtime");
		add(IF_SETOPBASE, "if_setopbase");
		add(IF_SETTARGETVERB, "if_settargetverb");
		add(IF_CLEAROPS, "if_clearops");
		add(IF_SETOPKEY, "if_setopkey");
		add(IF_SETOPTKEY, "if_setoptkey");
		add(IF_SETOPKEYRATE, "if_setopkeyrate");
		add(IF_SETOPTKEYRATE, "if_setoptkeyrate");
		add(IF_SETOPKEYIGNOREHELD, "if_setopkeyignoreheld");
		add(IF_SETOPTKEYIGNOREHELD, "if_setoptkeyignoreheld");
		add(IF_SETONCLICK, "if_setonclick");
		add(IF_SETONHOLD, "if_setonhold");
		add(IF_SETONRELEASE, "if_setonrelease");
		add(IF_SETONMOUSEOVER, "if_setonmouseover");
		add(IF_SETONMOUSELEAVE, "if_setonmouseleave");
		add(IF_SETONDRAG, "if_setondrag");
		add(IF_SETONTARGETLEAVE, "if_setontargetleave");
		add(IF_SETONVARTRANSMIT, "if_setonvartransmit");
		add(IF_SETONTIMER, "if_setontimer");
		add(IF_SETONOP, "if_setonop");
		add(IF_SETONDRAGCOMPLETE, "if_setondragcomplete");
		add(IF_SETONCLICKREPEAT, "if_setonclickrepeat");
		add(IF_SETONMOUSEREPEAT, "if_setonmouserepeat");
		add(IF_SETONINVTRANSMIT, "if_setoninvtransmit");
		add(IF_SETONSTATTRANSMIT, "if_setonstattransmit");
		add(IF_SETONTARGETENTER, "if_setontargetenter");
		add(IF_SETONSCROLLWHEEL, "if_setonscrollwheel");
		add(IF_SETONCHATTRANSMIT, "if_setonchattransmit");
		add(IF_SETONKEY, "if_setonkey");
		add(IF_SETONFRIENDTRANSMIT, "if_setonfriendtransmit");
		add(IF_SETONCLANTRANSMIT, "if_setonclantransmit");
		add(IF_SETONMISCTRANSMIT, "if_setonmisctransmit");
		add(IF_SETONDIALOGABORT, "if_setondialogabort");
		add(IF_SETONSUBCHANGE, "if_setonsubchange");
		add(IF_SETONSTOCKTRANSMIT, "if_setonstocktransmit");
		add(IF_SETONRESIZE, "if_setonresize");
		add(IF_GETX, "if_getx");
		add(IF_GETY, "if_gety");
		add(IF_GETWIDTH, "if_getwidth");
		add(IF_GETHEIGHT, "if_getheight");
		add(IF_GETHIDE, "if_gethide");
		add(IF_GETLAYER, "if_getlayer");
		add(IF_GETSCROLLX, "if_getscrollx");
		add(IF_GETSCROLLY, "if_getscrolly");
		add(IF_GETTEXT, "if_gettext");
		add(IF_GETSCROLLWIDTH, "if_getscrollwidth");
		add(IF_GETSCROLLHEIGHT, "if_getscrollheight");
		add(IF_GETMODELZOOM, "if_getmodelzoom");
		add(IF_GETMODELANGLE_X, "if_getmodelangle_x");
		add(IF_GETMODELANGLE_Z, "if_getmodelangle_z");
		add(IF_GETMODELANGLE_Y, "if_getmodelangle_y");
		add(IF_GETTRANS, "if_gettrans");
		add(IF_GETCOLOUR, "if_getcolour");
		add(IF_GETFILLCOLOUR, "if_getfillcolour");
		add(IF_GETINVOBJECT, "if_getinvobject");
		add(IF_GETINVCOUNT, "if_getinvcount");
		add(IF_HASSUB, "if_hassub");
		add(IF_GETTOP, "if_gettop");
		add(IF_GETTARGETMASK, "if_gettargetmask");
		add(IF_GETOP, "if_getop");
		add(IF_GETOPBASE, "if_getopbase");
		add(IF_CALLONRESIZE, "if_callonresize");
		add(MES, "mes");
		add(ANIM, "anim");
		add(IF_CLOSE, "if_close");
		add(RESUME_COUNTDIALOG, "resume_countdialog");
		add(RESUME_NAMEDIALOG, "resume_namedialog");
		add(RESUME_STRINGDIALOG, "resume_stringdialog");
		add(OPPLAYER, "opplayer");
		add(IF_DRAGPICKUP, "if_dragpickup");
		add(CC_DRAGPICKUP, "cc_dragpickup");
		add(MOUSECAM, "mousecam");
		add(GETREMOVEROOFS, "getremoveroofs");
		add(SETREMOVEROOFS, "setremoveroofs");
		add(OPENURL, "openurl");
		add(RESUME_OBJDIALOG, "resume_objdialog");
		add(BUG_REPORT, "bug_report");
		add(SETSHIFTCLICKDROP, "setshiftclickdrop");
		add(SETSHOWMOUSEOVERTEXT, "setshowmouseovertext");
		add(RENDERSELF, "renderself");
		add(SETSHOWMOUSECROSS, "setshowmousecross");
		add(SETSHOWLOADINGMESSAGES, "setshowloadingmessages");
		add(SETTAPTODROP, "settaptodrop");
		add(GETTAPTODROP, "gettaptodrop");
		add(GETCANVASSIZE, "getcanvassize");
		add(SETHIDEUSERNAME, "sethideusername");
		add(GETHIDEUSERNAME, "gethideusername");
		add(SETREMEMBERUSERNAME, "setrememberusername");
		add(GETREMEMBERUSERNAME, "getrememberusername");
		add(SOUND_SYNTH, "sound_synth");
		add(SOUND_SONG, "sound_song");
		add(SOUND_JINGLE, "sound_jingle");
		add(CLIENTCLOCK, "clientclock");
		add(INV_GETOBJ, "inv_getobj");
		add(INV_GETNUM, "inv_getnum");
		add(INV_TOTAL, "inv_total");
		add(INV_SIZE, "inv_size");
		add(STAT, "stat");
		add(STAT_BASE, "stat_base");
		add(STAT_XP, "stat_xp");
		add(COORD, "coord");
		add(COORDX, "coordx");
		add(COORDZ, "coordz");
		add(COORDY, "coordy");
		add(MAP_MEMBERS, "map_members");
		add(INVOTHER_GETOBJ, "invother_getobj");
		add(INVOTHER_GETNUM, "invother_getnum");
		add(INVOTHER_TOTAL, "invother_total");
		add(STAFFMODLEVEL, "staffmodlevel");
		add(REBOOTTIMER, "reboottimer");
		add(MAP_WORLD, "map_world");
		add(RUNENERGY_VISIBLE, "runenergy_visible");
		add(RUNWEIGHT_VISIBLE, "runweight_visible");
		add(PLAYERMOD, "playermod");
		add(WORLDFLAGS, "worldflags");
		add(MOVECOORD, "movecoord");
		add(ENUM_STRING, "enum_string");
		add(ENUM, "enum");
		add(ENUM_GETOUTPUTCOUNT, "enum_getoutputcount");
		add(FRIEND_COUNT, "friend_count");
		add(FRIEND_GETNAME, "friend_getname");
		add(FRIEND_GETWORLD, "friend_getworld");
		add(FRIEND_GETRANK, "friend_getrank");
		add(FRIEND_SETRANK, "friend_setrank");
		add(FRIEND_ADD, "friend_add");
		add(FRIEND_DEL, "friend_del");
		add(IGNORE_ADD, "ignore_add");
		add(IGNORE_DEL, "ignore_del");
		add(FRIEND_TEST, "friend_test");
		add(CLAN_GETCHATDISPLAYNAME, "clan_getchatdisplayname");
		add(CLAN_GETCHATCOUNT, "clan_getchatcount");
		add(CLAN_GETCHATUSERNAME, "clan_getchatusername");
		add(CLAN_GETCHATUSERWORLD, "clan_getchatuserworld");
		add(CLAN_GETCHATUSERRANK, "clan_getchatuserrank");
		add(CLAN_GETCHATMINKICK, "clan_getchatminkick");
		add(CLAN_KICKUSER, "clan_kickuser");
		add(CLAN_GETCHATRANK, "clan_getchatrank");
		add(CLAN_JOINCHAT, "clan_joinchat");
		add(CLAN_LEAVECHAT, "clan_leavechat");
		add(IGNORE_COUNT, "ignore_count");
		add(IGNORE_GETNAME, "ignore_getname");
		add(IGNORE_TEST, "ignore_test");
		add(CLAN_ISSELF, "clan_isself");
		add(CLAN_GETCHATOWNERNAME, "clan_getchatownername");
		add(CLAN_ISFRIEND, "clan_isfriend");
		add(CLAN_ISIGNORE, "clan_isignore");
		add(STOCKMARKET_GETOFFERTYPE, "stockmarket_getoffertype");
		add(STOCKMARKET_GETOFFERITEM, "stockmarket_getofferitem");
		add(STOCKMARKET_GETOFFERPRICE, "stockmarket_getofferprice");
		add(STOCKMARKET_GETOFFERCOUNT, "stockmarket_getoffercount");
		add(STOCKMARKET_GETOFFERCOMPLETEDCOUNT, "stockmarket_getoffercompletedcount");
		add(STOCKMARKET_GETOFFERCOMPLETEDGOLD, "stockmarket_getoffercompletedgold");
		add(STOCKMARKET_ISOFFEREMPTY, "stockmarket_isofferempty");
		add(STOCKMARKET_ISOFFERSTABLE, "stockmarket_isofferstable");
		add(STOCKMARKET_ISOFFERFINISHED, "stockmarket_isofferfinished");
		add(STOCKMARKET_ISOFFERADDING, "stockmarket_isofferadding");
		add(TRADINGPOST_SORTBY_NAME, "tradingpost_sortby_name");
		add(TRADINGPOST_SORTBY_PRICE, "tradingpost_sortby_price");
		add(TRADINGPOST_SORTFILTERBY_WORLD, "tradingpost_sortfilterby_world");
		add(TRADINGPOST_SORTBY_AGE, "tradingpost_sortby_age");
		add(TRADINGPOST_SORTBY_COUNT, "tradingpost_sortby_count");
		add(TRADINGPOST_GETTOTALOFFERS, "tradingpost_gettotaloffers");
		add(TRADINGPOST_GETOFFERWORLD, "tradingpost_getofferworld");
		add(TRADINGPOST_GETOFFERNAME, "tradingpost_getoffername");
		add(TRADINGPOST_GETOFFERPREVIOUSNAME, "tradingpost_getofferpreviousname");
		add(TRADINGPOST_GETOFFERAGE, "tradingpost_getofferage");
		add(TRADINGPOST_GETOFFERCOUNT, "tradingpost_getoffercount");
		add(TRADINGPOST_GETOFFERPRICE, "tradingpost_getofferprice");
		add(TRADINGPOST_GETOFFERITEM, "tradingpost_getofferitem");
		add(ADD, "add");
		add(SUB, "sub");
		add(MULTIPLY, "multiply");
		add(DIV, "div");
		add(RANDOM, "random");
		add(RANDOMINC, "randominc");
		add(INTERPOLATE, "interpolate");
		add(ADDPERCENT, "addpercent");
		add(SETBIT, "setbit");
		add(CLEARBIT, "clearbit");
		add(TESTBIT, "testbit");
		add(MOD, "mod");
		add(POW, "pow");
		add(INVPOW, "invpow");
		add(AND, "and");
		add(OR, "or");
		add(SCALE, "scale");
		add(APPEND_NUM, "append_num");
		add(APPEND, "append");
		add(APPEND_SIGNNUM, "append_signnum");
		add(LOWERCASE, "lowercase");
		add(FROMDATE, "fromdate");
		add(TEXT_GENDER, "text_gender");
		add(TOSTRING, "tostring");
		add(COMPARE, "compare");
		add(PARAHEIGHT, "paraheight");
		add(PARAWIDTH, "parawidth");
		add(TEXT_SWITCH, "text_switch");
		add(ESCAPE, "escape");
		add(APPEND_CHAR, "append_char");
		add(CHAR_ISPRINTABLE, "char_isprintable");
		add(CHAR_ISALPHANUMERIC, "char_isalphanumeric");
		add(CHAR_ISALPHA, "char_isalpha");
		add(CHAR_ISNUMERIC, "char_isnumeric");
		add(STRING_LENGTH, "string_length");
		add(SUBSTRING, "substring");
		add(REMOVETAGS, "removetags");
		add(STRING_INDEXOF_CHAR, "string_indexof_char");
		add(STRING_INDEXOF_STRING, "string_indexof_string");
		add(OC_NAME, "oc_name");
		add(OC_OP, "oc_op");
		add(OC_IOP, "oc_iop");
		add(OC_COST, "oc_cost");
		add(OC_STACKABLE, "oc_stackable");
		add(OC_CERT, "oc_cert");
		add(OC_UNCERT, "oc_uncert");
		add(OC_MEMBERS, "oc_members");
		add(OC_PLACEHOLDER, "oc_placeholder");
		add(OC_UNPLACEHOLDER, "oc_unplaceholder");
		add(OC_FIND, "oc_find");
		add(OC_FINDNEXT, "oc_findnext");
		add(OC_FINDRESET, "oc_findreset");
		add(CHAT_GETFILTER_PUBLIC, "chat_getfilter_public");
		add(CHAT_SETFILTER, "chat_setfilter");
		add(CHAT_SENDABUSEREPORT, "chat_sendabusereport");
		add(CHAT_GETHISTORY_BYTYPEANDLINE, "chat_gethistory_bytypeandline");
		add(CHAT_GETHISTORY_BYUID, "chat_gethistory_byuid");
		add(CHAT_GETFILTER_PRIVATE, "chat_getfilter_private");
		add(CHAT_SENDPUBLIC, "chat_sendpublic");
		add(CHAT_SENDPRIVATE, "chat_sendprivate");
		add(CHAT_PLAYERNAME, "chat_playername");
		add(CHAT_GETFILTER_TRADE, "chat_getfilter_trade");
		add(CHAT_GETHISTORYLENGTH, "chat_gethistorylength");
		add(CHAT_GETNEXTUID, "chat_getnextuid");
		add(CHAT_GETPREVUID, "chat_getprevuid");
		add(DOCHEAT, "docheat");
		add(CHAT_SETMESSAGEFILTER, "chat_setmessagefilter");
		add(CHAT_GETMESSAGEFILTER, "chat_getmessagefilter");
		add(GETWINDOWMODE, "getwindowmode");
		add(SETWINDOWMODE, "setwindowmode");
		add(GETDEFAULTWINDOWMODE, "getdefaultwindowmode");
		add(SETDEFAULTWINDOWMODE, "setdefaultwindowmode");
		add(CAM_FORCEANGLE, "cam_forceangle");
		add(CAM_GETANGLE_XA, "cam_getangle_xa");
		add(CAM_GETANGLE_YA, "cam_getangle_ya");
		add(CAM_SETFOLLOWHEIGHT, "cam_setfollowheight");
		add(CAM_GETFOLLOWHEIGHT, "cam_getfollowheight");
		add(LOGOUT, "logout");
		add(VIEWPORT_SETFOV, "viewport_setfov");
		add(VIEWPORT_SETZOOM, "viewport_setzoom");
		add(VIEWPORT_CLAMPFOV, "viewport_clampfov");
		add(VIEWPORT_GETEFFECTIVESIZE, "viewport_geteffectivesize");
		add(VIEWPORT_GETZOOM, "viewport_getzoom");
		add(VIEWPORT_GETFOV, "viewport_getfov");
		add(WORLDLIST_FETCH, "worldlist_fetch");
		add(WORLDLIST_START, "worldlist_start");
		add(WORLDLIST_NEXT, "worldlist_next");
		add(WORLDLIST_SPECIFIC, "worldlist_specific");
		add(WORLDLIST_SORT, "worldlist_sort");
		add(SETFOLLOWEROPSLOWPRIORITY, "setfolloweropslowpriority");
		add(NC_PARAM, "nc_param");
		add(LC_PARAM, "lc_param");
		add(OC_PARAM, "oc_param");
		add(STRUCT_PARAM, "struct_param");
		add(ON_MOBILE, "on_mobile");
		add(CLIENTTYPE, "clienttype");
		add(BATTERYLEVEL, "batterylevel");
		add(BATTERYCHARGING, "batterycharging");
		add(WIFIAVAILABLE, "wifiavailable");
		add(WORLDMAP_GETMAPNAME, "worldmap_getmapname");
		add(WORLDMAP_SETMAP, "worldmap_setmap");
		add(WORLDMAP_GETZOOM, "worldmap_getzoom");
		add(WORLDMAP_SETZOOM, "worldmap_setzoom");
		add(WORLDMAP_ISLOADED, "worldmap_isloaded");
		add(WORLDMAP_JUMPTODISPLAYCOORD, "worldmap_jumptodisplaycoord");
		add(WORLDMAP_JUMPTODISPLAYCOORD_INSTANT, "worldmap_jumptodisplaycoord_instant");
		add(WORLDMAP_JUMPTOSOURCECOORD, "worldmap_jumptosourcecoord");
		add(WORLDMAP_JUMPTOSOURCECOORD_INSTANT, "worldmap_jumptosourcecoord_instant");
		add(WORLDMAP_GETDISPLAYPOSITION, "worldmap_getdisplayposition");
		add(WORLDMAP_GETCONFIGORIGIN, "worldmap_getconfigorigin");
		add(WORLDMAP_GETCONFIGSIZE, "worldmap_getconfigsize");
		add(WORLDMAP_GETCONFIGBOUNDS, "worldmap_getconfigbounds");
		add(WORLDMAP_GETCONFIGZOOM, "worldmap_getconfigzoom");
		add(WORLDMAP_GETCURRENTMAP, "worldmap_getcurrentmap");
		add(WORLDMAP_GETDISPLAYCOORD, "worldmap_getdisplaycoord");
		add(WORLDMAP_COORDINMAP, "worldmap_coordinmap");
		add(WORLDMAP_GETSIZE, "worldmap_getsize");
		add(WORLDMAP_PERPETUALFLASH, "worldmap_perpetualflash");
		add(WORLDMAP_FLASHELEMENT, "worldmap_flashelement");
		add(WORLDMAP_FLASHELEMENTCATEGORY, "worldmap_flashelementcategory");
		add(WORLDMAP_STOPCURRENTFLASHES, "worldmap_stopcurrentflashes");
		add(WORLDMAP_DISABLEELEMENTS, "worldmap_disableelements");
		add(WORLDMAP_DISABLEELEMENT, "worldmap_disableelement");
		add(WORLDMAP_DISABLEELEMENTCATEGORY, "worldmap_disableelementcategory");
		add(WORLDMAP_GETDISABLEELEMENTS, "worldmap_getdisableelements");
		add(WORLDMAP_GETDISABLEELEMENT, "worldmap_getdisableelement");
		add(WORLDMAP_GETDISABLEELEMENTCATEGORY, "worldmap_getdisableelementcategory");
		add(WORLDMAP_LISTELEMENT_START, "worldmap_listelement_start");
		add(WORLDMAP_LISTELEMENT_NEXT, "worldmap_listelement_next");
		add(MEC_TEXT, "mec_text");
		add(MEC_TEXTSIZE, "mec_textsize");
		add(MEC_CATEGORY, "mec_category");
		add(MEC_SPRITE, "mec_sprite");
	}

	protected void add(int opcode, String name)
	{
		Instruction i = new Instruction(opcode);
		i.setName(name);
=======
		add(LOAD_INT, "load_int", 0, 1);
		add(GET_VARP, "get_varp", 0, 1);
		add(PUT_VARP, "put_varp", 0, 1);
		add(LOAD_STRING, "load_string", 0, 0, 0, 1);
		add(JUMP, "jump", 0, 0);
		add(IF_ICMPNE, "if_icmpne", 2, 0);
		add(IF_ICMPEQ, "if_icmpeq", 2, 0);
		add(IF_ICMPLT, "if_icmplt", 2, 0);
		add(IF_ICMPGT, "if_icmpgt", 2, 0);
		add(RETURN, "return", 0, 0);
		add(GET_VARBIT, "get_varbit", 0, 1);
		add(SET_VARBIT, "set_varbit", 1, 0);
		add(IF_ICMPLE, "if_icmple", 2, 0);
		add(IF_ICMPGE, "if_icmpge", 2, 0);
		add(ILOAD, "iload", 0, 1);
		add(ISTORE, "istore", 1, 0);
		add(SLOAD, "sload", 0, 0, 0, 1);
		add(SSTORE, "sstore", 0, 0, 1, 0);
		add(STRING_APPEND, "string_append", 0, 0, -1, 1);
		add(POP_INT, "pop_int", 1, 0);
		add(POP_STRING, "pop_string", 0, 0, 1, 0);
		add(INVOKE, "invoke", -1, -1, -1, -1);
		add(GET_VARC, "get_varc", 0, 1);
		add(PUT_VARC, "put_varc", 1, 0);
		add(ARRAY_INITIALIZE, "array_initialize", 1, 0);
		add(ARRAY_LOAD, "array_load", 1, 1);
		add(ARRAY_STORE, "array_store", 2, 0);
		add(GET_VARC_STRING, "get_varc_string", 0, 0, 0, 1);
		add(PUT_VARC_STRING, "put_varc_string", 0, 0, 1, 0);
		add(GET_VARC_STRING_2, "get_varc_string2", 0, 0, 0, 1);
		add(PUT_VARC_STRING_2, "put_varc_string2", 0, 0, 1, 0);
		add(SWITCH, "switch", 1, 0);
		add(WIDGET_CREATE_CHILD, "widget_create_child", 3, 0);
		add(WIDGET_DESTROY_CHILD, "widget_destroy_child", 0, 0);
		add(WIDGET_UNSET_CHILDREN, "widget_unset_children", 1, 0);
		add(WIDGET_LOAD_CHILD, "widget_load_child", 2, 1);
		add(WIDGET_LOAD, "widget_load", 1, 1);
		// 2000-2100 are the same as 1000-1100, but
		// pop an additional int which is used to get the current widget
		add(WIDGET_PUT_POSITION, "widget_put_position", 4, 0);
		add(WIDGET_PUT_SIZE, "widget_put_size", 4, 0);
		add(WIDGET_PUT_HIDDEN, "widget_put_hidden", 1, 0);
		add(WIDGET_PUT_NO_CLICK_THROUGH, "widget_put_no_click_through", 1, 0);
		add(1006, 1, 0);
		// 2100-2200 and 1100-1200 do the same thing
		add(WIDGET_PUT_SCROLL, "widget_put_scroll", 2, 0);
		add(WIDGET_PUT_TEXTCOLOR, "widget_put_textcolor", 1, 0);
		add(WIDGET_PUT_FILLED, "widget_put_filled", 1, 0);
		add(WIDGET_PUT_OPACITY, "widget_put_opacity", 1, 0);
		add(WIDGET_PUT_LINE_WIDTH, "widget_put_line_width", 1, 0);
		add(WIDGET_PUT_SPRITEID, "widget_put_spriteid", 1, 0);
		add(WIDGET_PUT_TEXTUREID, "widget_put_textureid", 1, 0);
		add(WIDGET_PUT_SPRITE_TILING, "widget_put_sprite_tiling", 1, 0);
		add(WIDGET_PUT_MODELID_1, "widget_put_modelid_1", 1, 0);
		add(WIDGET_PUT_3D_ROTATION, "widget_put_3d_rotation", 6, 0);
		add(WIDGET_PUT_ANIMATION, "widget_put_animation", 1, 0);
		add(1111, 1, 0);
		add(WIDGET_PUT_TEXT, "widget_put_text", 0, 0, 1, 0);
		add(WIDGET_PUT_FONTID, "widget_put_fontid", 1, 0);
		add(WIDGET_PUT_TEXT_ALIGNMENT, "widget_put_text_alignment", 3, 0);
		add(WIDGET_PUT_TEXT_SHADOWED, "widget_put_text_shadowed", 1, 0);
		add(WIDGET_PUT_BORDERTHICKNESS, "widget_put_borderthickness", 1, 0);
		add(WIDGET_PUT_SPRITE2, "widget_put_sprite2", 1, 0);
		add(WIDGET_PUT_FLIPPEDVERTICALLY, "widget_put_flippedvertically", 1, 0);
		add(WIDGET_PUT_FLIPPEDHORIZONALLY, "widget_put_flippedhorizonally", 1, 0);
		add(WIDGET_PUT_SCROLLWIDTHHEIGHT, "widget_put_scrollwidthheight", 2, 0);
		add(WIDGET_ADVANCE_DIALOGUE, "widget_advance_dialogue", 0, 0);
		add(1122, 1, 0);
		add(1123, 1, 0);
		add(1124, 1, 0);
		add(1125, 1, 0);
		// and 1200-1300 and 2200-2300
		add(WIDGET_PUT_MODELID_2, "widget_put_modelid_2", 1, 0);
		add(WIDGET_PUT_MODELID_3, "widget_put_modelid_3", 0, 0);
		add(1200, 2, 0);
		add(1205, 2, 0);
		add(1212, 2, 0);
		// and 1300-1400 and 2300-2400
		add(WIDGET_PUT_ACTION, "widget_put_action", 1, 0, 1, 0);
		add(WIDGET_PUT_DRAG_PARENT, "widget_put_drag_parent", 2, 0);
		add(1302, 1, 0);
		add(1303, 1, 0);
		add(1304, 1, 0);
		add(WIDGET_PUT_NAME, "widget_put_name", 0, 0, 1, 0);
		add(WIDGET_PUT_SELECTED_ACTION, "widget_put_selected_action", 0, 0, 1, 0);
		add(WIDGET_PUT_ACTIONS_NULL, "widget_put_actions_null", 0, 0);
		// and 1400-1500 and 2400-2500
		add(WIDGET_PUT_MOUSE_PRESS_LISTENER, "widget_put_mouse_press_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAGGED_OVER_LISTENER, "widget_put_mouse_dragged_over_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_RELEASE_LISTENER, "widget_put_mouse_release_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_ENTER_LISTENER, "widget_put_mouse_enter_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_EXIT_LISTENER, "widget_put_mouse_exit_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_START_LISTENER, "widget_put_drag_start_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_WITH_LISTENER, "widget_put_use_with_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_CONFIG_LISTENER, "widget_put_config_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_RENDER_LISTENER, "widget_put_render_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_OPTION_CLICK_LISTENER, "widget_put_option_click_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_RELEASE_LISTENER, "widget_put_drag_release_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_LISTENER, "widget_put_drag_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_HOVER_LISTENER, "widget_put_mouse_hover_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_TABLE_LISTENER, "widget_put_table_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_SKILL_LISTENER, "widget_put_skill_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_LISTENER, "widget_put_use_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_SCROLL_LISTENER, "widget_put_scroll_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_MSG_LISTENER, "widget_put_msg_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_KEY_LISTENER, "widget_put_key_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_FRIENDS_LISTENER, "widget_put_friends_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_CLAN_LISTENER, "widget_put_clan_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_DIALOG_ABORT_LISTENER, "widget_put_dialog_abort_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_OPENCLOSE_LISTENER, "widget_put_openclose_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_GE_LISTENER, "widget_put_ge_listener", -1, 0, -1, 0);
		add(WIDGET_PUT_RESIZE_LISTENER, "widget_put_resize_listener", -1, 0, -1, 0);
		// and 1500-1600 and 2500-2600
		add(WIDGET_GET_RELATIVEX, "widget_get_relativex", 0, 1);
		add(WIDGET_GET_RELATIVEY, "widget_get_relativey", 0, 1);
		add(WIDGET_GET_WIDTH, "widget_get_width", 0, 1);
		add(WIDGET_GET_HEIGHT, "widget_get_height", 0, 1);
		add(WIDGET_GET_HIDDEN, "widget_get_hidden", 0, 1);
		add(WIDGET_GET_PARENTID, "widget_get_parentid", 0, 1);
		// and 1600-1700 and 2600-2700
		add(WIDGET_GET_SCROLLX, "widget_get_scrollx", 0, 1);
		add(WIDGET_GET_SCROLLY, "widget_get_scrolly", 0, 1);
		add(WIDGET_GET_TEXT, "widget_get_text", 0, 0, 0, 1);
		add(WIDGET_GET_SCROLLWIDTH, "widget_get_scrollwidth", 0, 1);
		add(WIDGET_GET_SCROLLHEIGHT, "widget_get_scrollheight", 0, 1);
		add(WIDGET_GET_MODELZOOM, "widget_get_modelzoom", 0, 1);
		add(WIDGET_GET_ROTATIONX, "widget_get_rotationx", 0, 1);
		add(WIDGET_GET_ROTATIONY, "widget_get_rotationy", 0, 1);
		add(WIDGET_GET_ROTATIONZ, "widget_get_rotationz", 0, 1);
		add(WIDGET_GET_OPACITY, "widget_get_opacity", 0, 1);
		add(1610, 0, 1);
		add(WIDGET_GET_TEXTCOLOR, "widget_get_textcolor", 0, 1);
		add(1612, 0, 1);
		add(1613, 0, 1);
		// 1700
		add(WIDGET_GET_ITEMID, "widget_get_itemid", 0, 1);
		add(WIDGET_GET_STACKSIZE, "widget_get_stacksize", 0, 1);
		add(WIDGET_GET_INDEX, "widget_get_index", 0, 1);
		add(WIDGET_GET_CONFIG, "widget_get_config", 0, 1);
		add(WIDGET_GET_ACTION, "widget_get_action", 1, 0, 0, 1);
		add(WIDGET_GET_NAME, "widget_get_name", 0, 0, 0, 1);
		// and 1900-2000 and 2900-3000
		add(1927, 0, 0);
		// 2000-2100
		add(WIDGET_PUT_POSITION_WIDGET, "widget_put_position_widget", 5, 0);
		add(WIDGET_PUT_SIZE_WIDGET, "widget_put_size_widget", 5, 0);
		add(WIDGET_PUT_HIDDEN_WIDGET, "widget_put_hidden_widget", 2, 0);
		add(WIDGET_PUT_NO_CLICK_THROUGH_WIDGET, "widget_put_no_click_through_widget", 2, 0);
		add(2006, 2, 0);
		// 2100-2200
		add(WIDGET_PUT_SCROLL_WIDGET, "widget_put_scroll_widget", 3, 0);
		add(WIDGET_PUT_TEXTCOLOR_WIDGET, "widget_put_textcolor_widget", 2, 0);
		add(WIDGET_PUT_FILLED_WIDGET, "widget_put_filled_widget", 2, 0);
		add(WIDGET_PUT_OPACITY_WIDGET, "widget_put_opacity_widget", 2, 0);
		add(WIDGET_PUT_LINE_WIDTH_WIDGET, "widget_put_line_width_widget", 2, 0);
		add(WIDGET_PUT_SPRITEID_WIDGET, "widget_put_spriteid_widget", 2, 0);
		add(WIDGET_PUT_TEXTUREID_WIDGET, "widget_put_textureid_widget", 2, 0);
		add(WIDGET_PUT_SPRITE_TILING_WIDGET, "widget_put_sprite_tiling_widget", 2, 0);
		add(WIDGET_PUT_MODELID_1_WIDGET, "widget_put_modelid_1_widget", 2, 0);
		add(WIDGET_PUT_3D_ROTATION_WIDGET, "widget_put_3d_rotation_widget", 7, 0);
		add(WIDGET_PUT_ANIMATION_WIDGET, "widget_put_animation_widget", 2, 0);
		add(2111, 2, 0);
		add(WIDGET_PUT_TEXT_WIDGET, "widget_put_text_widget", 1, 0, 1, 0);
		add(WIDGET_PUT_FONTID_WIDGET, "widget_put_fontid_widget", 2, 0);
		add(WIDGET_PUT_TEXT_ALIGNMENT_WIDGET, "widget_put_text_alignment_widget", 4, 0);
		add(WIDGET_PUT_TEXT_SHADOWED_WIDGET, "widget_put_text_shadowed_widget", 2, 0);
		add(WIDGET_PUT_BORDERTHICKNESS_WIDGET, "widget_put_borderthickness_widget", 2, 0);
		add(WIDGET_PUT_SPRITE2_WIDGET, "widget_put_sprite2_widget", 2, 0);
		add(WIDGET_PUT_FLIPPEDVERTICALLY_WIDGET, "widget_put_flippedvertically_widget", 2, 0);
		add(WIDGET_PUT_FLIPPEDHORIZONALLY_WIDGET, "widget_put_flippedhorizonally_widget", 2, 0);
		add(WIDGET_PUT_SCROLLWIDTHHEIGHT_WIDGET, "widget_put_scrollwidthheight_widget", 3, 0);
		add(WIDGET_ADVANCE_DIALOGUE_WIDGET, "widget_advance_dialogue_window", 1, 0);
		add(2122, 2, 0);
		add(2123, 2, 0);
		add(2124, 2, 0);
		add(2125, 2, 0);
		// 2200-2300
		add(WIDGET_PUT_MODELID_2_WIDGET, "widget_put_modelid_2_widget", 2, 0);
		add(WIDGET_PUT_MODELID_3_WIDGET, "widget_put_modelid_3_widget", 1, 0);
		add(2200, 3, 0);
		add(2205, 3, 0);
		add(2212, 3, 0);
		// 2300-2400
		add(WIDGET_PUT_ACTION_WIDGET, "widget_put_action_widget", 2, 0, 1, 0);
		add(WIDGET_PUT_DRAG_PARENT_WIDGET, "widget_put_drag_parent_widget", 3, 0);
		add(2302, 2, 0);
		add(2303, 2, 0);
		add(2304, 2, 0);
		add(WIDGET_PUT_NAME_WIDGET, "widget_put_name_widget", 1, 0, 1, 0);
		add(WIDET_PUT_SELECTED_ACTION_WIDGET, "widget_put_selected_action_widget", 1, 0, 1, 0);
		add(WIDGET_PUT_ACTIONS_NULL_WIDGET, "widget_put_actions_null_widget", 1, 0);
		// 2400-2500
		add(WIDGET_PUT_MOUSE_PRESS_LISTENER_WIDGET, "widget_put_mouse_press_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAGGED_OVER_LISTENER_WIDGET, "widget_put_dragged_over_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_RELEASE_LISTENER_WIDGET, "widget_put_mouse_release_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_ENTER_LISTENER_WIDGET, "widget_put_mouse_enter_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_EXIT_LISTENER_WIDGET, "widget_put_mouse_exit_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_START_LISTENER_WIDGET, "widget_put_drag_start_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_WITH_LISTENER_WIDGET, "widget_put_mouse_use_with_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_CONFIG_LISTENER_WIDGET, "widget_put_config_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_RENDER_LISTENER_WIDGET, "widget_put_render_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_OPTION_CLICK_LISTENER_WIDGET, "widget_put_option_click_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_RELEASE_LISTENER_WIDGET, "widget_put_drag_release_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_LISTENER_WIDGET, "widget_put_drag_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_HOVER_LISTENER_WIDGET, "widget_put_mouse_hover_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_TABLE_LISTENER_WIDGET, "widget_put_table_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_SKILL_LISTENER_WIDGET, "widget_put_skill_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_LISTENER_WIDGET, "widget_put_use_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_SCROLL_LISTENER_WIDGET, "widget_put_scroll_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_MSG_LISTENER_WIDGET, "widget_put_msg_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_KEY_LISTENER_WIDGET, "widget_put_key_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_FRIENDS_LISTENER_WIDGET, "widget_put_friends_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_CLAN_LISTENER_WIDGET, "widget_put_clan_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_DIALOG_ABORT_LISTENER_WIDGET, "widget_put_dialog_abort_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_OPENCLOSE_LISTENER_WIDGET, "widget_put_openclose_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_GE_LISTENER_WIDGET, "widget_put_ge_listener_widget", -1, 0, -1, 0);
		add(WIDGET_PUT_RESIZE_LISTENER_WIDGET, "widget_put_resize_listener_widget", -1, 0, -1, 0);
		// 2500-2600
		add(WIDGET_GET_RELATIVEX_WIDGET, "widget_get_relativex_widget", 1, 1);
		add(WIDGET_GET_RELATIVEY_WIDGET, "widget_get_relativey_widget", 1, 1);
		add(WIDGET_GET_WIDTH_WIDGET, "widget_get_width_widget", 1, 1);
		add(WIDGET_GET_HEIGHT_WIDGET, "widget_get_height_widget", 1, 1);
		add(WIDGET_GET_HIDDEN_WIDGET, "widget_get_hidden_widget", 1, 1);
		add(WIDGET_GET_PARENTID_WIDGET, "widget_get_parentid_widget", 1, 1);
		// 2600-2700
		add(WIDGET_GET_SCROLLX_WIDGET, "widget_get_scrollx_widget", 1, 1);
		add(WIDGET_GET_SCROLLY_WIDGET, "widget_get_scrolly_widget", 1, 1);
		add(WIDGET_GET_TEXT_WIDGET, "widget_get_text_widget", 1, 0, 0, 1);
		add(WIDGET_GET_SCROLLWIDTH_WIDGET, "widget_get_scrollwidth_widget", 1, 1);
		add(WIDGET_GET_SCROLLHEIGHT_WIDGET, "widget_get_scrollheight_widget", 1, 1);
		add(WIDGET_GET_MODELZOOM_WIDGET, "widget_get_modelzoom_widget", 1, 1);
		add(WIDGET_GET_ROTATIONX_WIDGET, "widget_get_rotationx_widget", 1, 1);
		add(WIDGET_GET_ROTATIONY_WIDGET, "widget_get_rotationy_widget", 1, 1);
		add(WIDGET_GET_ROTATIONZ_WIDGET, "widget_get_rotationz_widget", 1, 1);
		add(WIDGET_GET_OPACITY_WIDGET, "widget_get_opacity_widget", 1, 1);
		add(2610, 1, 1);
		add(WIDGET_GET_TEXTCOLOR_WIDGET, "widget_get_textcolor_widget", 1, 1);
		add(2612, 1, 1);
		add(2613, 1, 1);
		// 2700-2800
		add(WIDGET_GET_ITEMID_WIDGET, "widget_get_itemid_widget", 1, 1);
		add(WIDGET_GET_STACKSIZE_WIDGET, "widget_get_stacksize_widget", 1, 1);
		add(WIGET_GET_INDEX_WIDGET, "widget_get_index_widget", 1, 1);
		add(GET_WIDGET_ROOT, "get_widget_root", 0, 1);
		// 2800-2900
		add(WIDGET_GET_CONFIG_WIGET, "widget_get_config_widget", 1, 1);
		add(WIDGET_GET_ACTION_WIDGET, "widget_get_action_widget", 2, 0, 0, 1);
		add(WIDGET_GET_NAME_WIDGET, "widget_get_name_widget", 1, 0, 0, 1);
		// 2900-3000
		add(2927, 1, 0);
		// 3000-3200
		add(SEND_GAME_MESSAGE, "send_game_message", 0, 0, 1, 0);
		add(PLAYER_ANIMATE, "player_animate", 2, 0);
		add(CLOSE_WINDOW, "close_window", 0, 0);
		add(NUMERIC_INPUT, "numeric_input", 0, 0, 1, 0);
		add(STRING_INPUT_1, "string_input_1", 0, 0, 1, 0);
		add(STRING_INPUT_2, "string_input_2", 0, 0, 1, 0);
		add(PLAYER_ACTION, "player_action", 1, 0, 1, 0);
		add(SET_TOP_CONTEXT_MENU_ROW, "set_top_context_menu_row", 3, 0);
		add(SET_TOP_CONTEXT_MENU_ROW_2, "set_top_context_menu_row_2", 2, 0);
		add(SET_MOUSE_BUTTON_CONTROLS_CAMERA, "set_mouse_button_controls_camera", 1, 0);
		add(GET_HIDEROOFS, "get_hideroofs", 0, 1);
		add(SET_HIDEROOFS, "set_hideroofs", 1, 0);
		add(OPEN_URL, "open_url", 1, 0, 1, 0);
		add(ITEM_PRICE, "item_price", 1, 0);
		add(SEND_BUG_REPORT, "send_bug_report", 1, 0, 2, 0);
		add(SET_SHIFT_DROP_ENABLED, "set_shift_drop_enabled", 1, 0);
		add(SET_CONNECTION_TEXT_ENABLED, "set_connection_text_enabled", 1, 0);
		// 3200-3300
		add(PLAY_SOUND_EFFECT, "play_sound_effect", 3, 0);
		add(3201, 1, 0);
		add(3202, 2, 0);
		// 3300-3400
		add(GET_GAMECYCLE, "get_gamecycle", 0, 1);
		add(GET_ITEMCONTAINER_ITEMID, "get_itemcontainer_itemid", 2, 0);
		add(GET_ITEMCONTAINER_STACKSIZE, "get_itemcontainer_stacksize", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZES_TOTAL, "get_itemcontainer_stacksizes_total", 2, 1);
		add(GET_INVENTORY_SIZE, "get_inventory_size", 1, 1);
		add(GET_BOOSTEDSKILLLEVELS, "get_boostedskilllevels", 1, 1);
		add(GET_REALSKILLLEVELS, "get_realskilllevels", 1, 1);
		add(GET_SKILLEXPERIENCES, "get_skillexperiences", 1, 1);
		add(GET_COORDINATES, "get_coordinates", 0, 1);
		add(DIVIDE_BY_16384, "divide_by_16384", 1, 1);
		add(RIGHT_SHIFT_28, "right_shift_28", 1, 1);
		add(AND_16384, "and_16384", 1, 1);
		add(GET_ISMEMBERS, "get_ismembers", 0, 1);
		add(GET_ITEMCONTAINER_ITEMID_2, "get_itemcontainer_itemid_2", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZE_2, "get_itemcontainer_stacksize_2", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZES_TOTAL_2, "get_itemcontainer_stacksizes_total_2", 2, 1);
		add(GET_RIGHTS, "get_rights", 0, 1);
		add(GET_SYSTEM_UPDATE_TIMER, "get_system_update_timer", 0, 1);
		add(GET_WORLDNUM, "get_worldnum", 0, 1);
		add(GET_ENERGY, "get_energy", 0, 1);
		add(GET_WEIGHT, "get_weight", 0, 1);
		add(GET_PLAYERMOD, "get_playermod", 0, 1);
		add(GET_FLAGS, "get_flags", 0, 1);
		add(PACK_LOCATION, "pack_location", 4, 1);
		// 3400-3500
		add(3400, 2, 0, 0, 1);
		add(GET_ENUM_VALUE, "get_enum_value", 4, -1, 0, -1); // this pushes an int or a string, depending on the argument
		// 3500-3700
		add(GET_FRIENDCOUNT, "get_friendcount", 0, 1);
		add(GET_FRIEND, "get_friend", 1, 0, 0, 2);
		add(GET_FRIEND_WORLD, "get_friend_world", 1, 1);
		add(GET_FRIEND_RANK, "get_friend_rank", 1, 1);
		add(3604, 1, 0, 1, 0);
		add(ADD_FRIEND, "add_friend", 0, 0, 1, 0);
		add(REMOVE_FRIEND, "remove_friend", 0, 0, 1, 0);
		add(ADD_IGNORE, "add_ignore", 0, 0, 1, 0);
		add(REMOVE_IGNORE, "remove_ignore", 0, 0, 1, 0);
		add(IS_FRIEND, "is_friend", 0, 1, 1, 0);
		add(GET_CLANCHAT_OWNER, "get_clanchat_owner", 0, 0, 0, 1);
		add(GET_CLANCHATCOUNT, "get_clanchatcount", 0, 1);
		add(GET_CLAN_MEMBER_NAME, "get_clan_member_name", 1, 0, 0, 1);
		add(GET_CLAN_MEMBER_WORLD, "get_clan_member_world", 1, 1);
		add(GET_CLAN_MEMBER_RANK, "get_clan_member_rank", 1, 1);
		add(CLANCHAT_KICK_RANK, "clanchat_kick_rank", 0, 1);
		add(CLANCHAT_KICK_CLANMEMBER, "clanchat_kick_clanmember", 0, 0, 1, 0);
		add(GET_CLANCHAT_RANK, "get_clanchat_rank", 0, 1);
		add(JOIN_CLANCHAT, "join_clanchat", 0, 0, 1, 0);
		add(PART_CLANCHAT, "part_clanchat", 0, 0);
		add(GET_IGNORECOUNT, "get_ignorecount", 0, 1);
		add(GET_IGNORE, "get_ignore", 1, 0, 0, 2);
		add(IS_IGNORE, "is_ignore", 0, 1, 1, 0);
		add(CLANMEMBER_ISME, "clanmember_isme", 1, 1);
		add(GET_CLANCHATOWNER, "get_clanchatowner", 0, 0, 0, 1);
		// 3700-4000
		add(GET_GRANDEXCHANGE_OFFER_IS_SELLING, "get_grandexchange_offer_is_selling", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_ITEMID, "get_grandexchange_offer_itemid", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_PRICE, "get_grandexchange_offer_price", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_TOTALQUANTITY, "get_grandexchange_offer_totalquantity", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_QUANTITYSOLD, "get_grandexchange_offer_quantitysold", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_SPENT, "get_grandexchange_offer_spent", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_NOT_STARTED, "get_grandexchange_offer_not_started", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_STATUS_2, "get_grandexchange_offer_status_2", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_DONE, "get_grandexchange_offer_done", 1, 1);
		add(3913, 1, 1);
		add(3914, 1, 0);
		add(3915, 1, 0);
		add(3916, 2, 0);
		add(3917, 1, 0);
		add(3918, 1, 0);
		add(3919, 0, 1);
		add(3920, 1, 1);
		add(3921, 1, 0, 0, 1);
		add(3922, 1, 0, 0, 1);
		add(3923, 1, 0, 0, 1);
		add(3924, 1, 1);
		add(3925, 1, 1);
		add(3926, 1, 1);
		// 4000-4100
		add(IADD, "iadd", 2, 1);
		add(ISUB, "isub", 2, 1);
		add(IMUL, "imul", 2, 1);
		add(IDIV, "idiv", 2, 1);
		add(RAND_EXCL, "rand_excl", 1, 1);
		add(RAND_INCL, "rand_incl", 1, 1);
		add(INTERPOLATE, "interpolate", 5, 1);
		add(ADD_PERCENT, "add_percent", 2, 1);
		add(SET_BIT, "set_bit", 2, 1);
		add(CLEAR_BIT, "clear_bit", 2, 1);
		add(TEST_BIT, "test_bit", 2, 1);
		add(MODULO, "modulo", 2, 1);
		add(POW, "pow", 2, 1);
		add(INVPOW, "invpow", 2, 1);
		add(AND, "and", 2, 1);
		add(OR, "or", 2, 1);
		add(SCALE, "scale", 3, 1);
		// 4100-4200
		add(CONCAT_INT, "concat_int", 1, 0, 1, 1);
		add(CONCAT_STRING, "concat_string", 0, 0, 2, 1);
		add(4102, 1, 0, 1, 1);
		add(TOLOWERCASE, "tolowercase", 0, 0, 1, 1);
		add(FORMAT_DATE, "format_date", 1, 0, 0, 1);
		add(SWITCH_MALE_OR_FEMALE, "switch_male_or_female", 0, 0, 2, 1);
		add(INT_TO_STRING, "int_to_string", 1, 0, 0, 1);
		add(STRING_COMPARE, "string_compare", 0, 1, 2, 0);
		add(GET_LINE_COUNT, "get_line_count", 2, 1, 1, 0);
		add(GET_MAX_LINE_WIDTH, "get_max_line_width", 2, 1, 1, 0);
		add(SWITCH_STRING, "switch_string", 1, 0, 2, 1);
		add(APPENDTAGS, "appendtags", 0, 0, 1, 1);
		add(CONCAT_CHAR, "concat_char", 1, 0, 1, 1);
		add(CHAR_IS_PRINTABLE, "char_is_printable", 1, 1);
		add(ISALNUM, "isalnum", 1, 1);
		add(ISALPHA, "isalpha", 1, 1);
		add(ISDIGIT, "isdigit", 1, 1);
		add(STRING_LENGTH, "string_length", 0, 1, 1, 0);
		add(STRING_SUBSTRING, "string_substring", 2, 0, 1, 1);
		add(STRING_REMOVE_HTML, "string_remove_html", 0, 0, 1, 1);
		add(STRING_INDEXOF, "string_indexof", 1, 1, 1, 0);
		add(STRING_INDEXOF_FROM, "string_indexof_from", 1, 1, 2, 0);
		// 4200-4300
		add(GET_ITEM_NAME, "get_item_name", 1, 0, 0, 1);
		add(GET_ITEM_GROUND_ACTION, "get_item_ground_action", 2, 0, 0, 1);
		add(GET_ITEM_INVENTORY_ACTION, "get_item_inventory_action", 2, 0, 0, 1);
		add(GET_ITEM_PRICE, "get_item_price", 1, 1);
		add(GET_ITEM_STACKABLE, "get_item_stackable", 1, 1);
		add(GET_ITEM_NOTE_1, "get_item_note_1", 1, 1);
		add(GET_ITEM_NOTE_2, "get_item_note_2", 1, 1);
		add(GET_ITEM_ISMEMBERS, "get_item_ismembers", 1, 1);
		add(4208, 1, 1);
		add(4209, 1, 1);
		add(SEARCH_ITEM, "search_item", 1, 1, 1, 0);
		add(NEXT_SEARCH_RESULT, "next_search_result", 0, 1);
		add(4212, 0, 0);
		// 4300-5100
		add(5000, 0, 1);
		add(CHATFILTER_UPDATE, "chatfilter_update", 3, 0);
		add(REPORT_PLAYER, "report_player", 2, 0, 1, 0);
		add(GET_CHAT_MESSAGE_TYPE, "get_chat_message_type", 2, 2, 0, 3);
		add(GET_CHAT_MESSAGE, "get_chat_message", 1, 2, 0, 3);
		add(5005, 0, 1);
		add(CHATBOX_INPUT, "chatbox_input", 1, 0, 1, 0);
		add(PRIVMSG, "privmsg", 0, 0, 2, 0);
		add(GET_LOCALPLAYER_NAME, "get_localplayer_name", 0, 0, 0, 1);
		add(5016, 0, 1);
		add(GET_CHATLINEBUFFER_LENGTH, "get_chatlinebuffer_length", 1, 1);
		add(GET_MESSAGENODE_PREV_ID, "get_messagenode_prev_id", 1, 1);
		add(GET_MESSAGENODE_NEXT_ID, "get_messagenode_next_id", 1, 1);
		add(RUN_COMMAND, "run_command", 0, 0, 1, 0);
		add(5021, 0, 0, 1, 0);
		add(5022, 0, 0, 0, 1);
		// 5100-5400
		add(GET_ISRESIZED, "get_isresized", 0, 1);
		add(SET_ISRESIZED, "set_isresized", 1, 0);
		add(GET_SCREENTYPE, "get_screentype", 0, 1);
		add(SET_SCREENTYPE, "set_screentype", 1, 0);
		// 5400-5600
		add(5504, 2, 0);
		add(5505, 0, 1);
		add(GET_MAPANGLE, "get_mapangle", 0, 1);
		add(SET_CAMERA_FOCAL_POINT_HEIGHT, "set_camera_focal_point_height", 1, 0);
		add(GET_CAMERA_FOCAL_POINT_HEIGHT, "get_camera_focal_point_height", 0, 1);
		// 5600-5700
		add(CANCEL_LOGIN, "cancel_login", 0, 0);
		// 5700-6300
		add(6200, 2, 0);
		add(SET_ZOOM_DISTANCE, "set_zoom_distance", 2, 0);
		add(6202, 4, 0);
		add(GET_VIEWPORT_SIZE, "get_viewport_size", 0, 2);
		add(GET_ZOOM_DISTANCE, "get_zoom_distance", 0, 2);
		add(6205, 0, 2);
		// 6300-6600
		add(LOAD_WORLDS, "load_worlds", 0, 1);
		add(GET_FIRST_WORLD, "get_first_world", 0, 4, 0, 2);
		add(GET_NEXT_WORLD, "get_next_world", 0, 4, 0, 2);
		add(GET_WORLD_BY_ID, "get_world_by_id", 1, 4, 0, 2);
		add(6507, 4, 0);
		add(GET_WORLD_BY_INDEX, "get_world_by_index", 1, 4, 0, 2);
		add(6512, 1, 0);
		add(GET_IS_MOBILE, "get_is_mobile", 0, 1);
		// 6600-6700
		add(6600, 0, 0);
		add(GET_MAP_SURFACE_NAME_BY_ID, "get_map_surface_name_by_id", 1, 0, 0, 1);
		add(SET_CURRENT_MAP_SURFACE, "set_current_map_surface", 1, 0);
		add(GET_CURRENT_MAP_ZOOM, "get_current_map_zoom", 0, 1);
		add(SET_CURRENT_MAP_ZOOM, "set_current_map_zoom", 1, 0);
		add(6605, 0, 1);
		add(SET_MAP_POSITION, "set_map_position", 1, 0);
		add(SET_MAP_POSITION_IMMEDIATE, "set_map_position_immediate", 1, 0);
		add(SET_MAP_POSITION_2, "set_map_position_2", 1, 0);
		add(SET_MAP_POSITION_IMMEDIATE_2, "set_map_position_immediate_2", 1, 0);
		add(GET_MAP_POSITION, "get_map_position", 0, 2);
		add(GET_MAP_DEFAULT_POSITION_BY_ID, "get_map_default_position_by_id", 1, 1);
		add(GET_MAP_DIMENSIONS_BY_ID, "get_map_dimensions_by_id", 1, 2);
		add(GET_MAP_BOUNDS_BY_ID, "get_map_bounds_by_id", 1, 4);
		add(GET_MAP_INITAL_ZOOM_BY_ID, "get_map_inital_zoom_by_id", 1, 1);
		add(6615, 2, 2);
		add(GET_CURRENT_MAP_ID, "get_current_map_id", 0, 1);
		add(6617, 1, 2);
		// 6618 variable
		add(6619, 2, 1);
		add(6620, 2, 1);
		add(MAP_ID_CONTAINS_COORD, "map_id_contains_coord", 2, 1);
		add(GET_MAP_DISPLAY_DIMENSIONS, "get_map_display_dimensions", 0, 2);
		add(GET_MAP_ID_CONTAINING_COORD, "get_map_id_containing_coord", 1, 1);
		add(SET_MAP_ICON_FLASH_COUNT, "set_map_icon_flash_count", 1, 0);
		add(RESET_MAP_ICON_FLASH_COUNT, "reset_map_icon_flash_count", 0, 0);
		add(SET_MAP_ICON_FLASH_PERIOD, "set_map_icon_flash_period", 1, 0);
		add(RESET_MAP_ICON_FLASH_PERIOD, "reset_map_icon_flash_period", 0, 0);
		add(SET_MAP_ICON_FLASH_FOREVER, "set_map_icon_flash_forever", 1, 0);
		add(FLASH_MAP_ICONS_BY_ID, "flash_map_icons_by_id", 1, 0);
		add(FLASH_MAP_ICONS_BY_GROUP, "flash_map_icons_by_group", 1, 0);
		add(CLEAR_FLASHING_ICONS, "clear_flashing_icons", 0, 0);
		add(SET_MAP_ICONS_DISABLED, "set_map_icons_disabled", 1, 0);
		add(SET_MAP_ICONS_ENABLED_BY_ID, "set_map_icons_enabled_by_id", 2, 0);
		add(SET_MAP_ICONS_ENABLED_BY_GROUP, "set_map_icons_enabled_by_group", 2, 0);
		add(GET_MAP_ICONS_DISABLED, "get_map_icons_disabled", 0, 1);
		add(GET_MAP_ICONS_ENABLED_BY_ID, "get_map_icons_enabled_by_id", 1, 1);
		add(GET_MAP_ICONS_ENABLED_BY_GROUP, "get_map_icons_enabled_by_group", 1, 1);
		add(6638, 2, 1);
		add(GET_FIRST_MAP_ICON, "get_first_map_icon", 0, 2);
		add(GET_NEXT_MAP_ICON, "get_next_map_icon", 0, 2);
		add(GET_MAPICON_NAME_BY_ID, "get_mapicon_name_by_id", 1, 0, 0, 1);
		add(GET_MAPICON_FONT_SIZE, "get_mapicon_font_size", 1, 1);
		add(GET_MAPICON_GROUP_BY_ID, "get_mapicon_group_by_id", 1, 1);
		add(GET_MAPICON_SPRITE_BY_ID, "get_mapicon_sprite_by_id",	 1, 1);
		add(GET_CURRENT_MAPICON_ID, "get_current_mapicon_id", 0, 1);
		add(GET_CURRENT_MAPICON_COORD, "get_current_mapicon_coord", 0, 1);
		add(GET_CURRENT_MAPICON_OTHER_COORD, "get_current_mapicon_other_coord", 0, 1);
	}

	protected void add(int opcode, String name, int ipops, int ipushes, int spops, int spushes)
	{
		Instruction i = new Instruction(opcode);
		i.setName(name);
		i.setIntStackPops(ipops);
		i.setIntStackPushes(ipushes);
		i.setStringStackPops(spops);
		i.setStringStackPushes(spushes);
>>>>>>> initial import of runelite

		assert instructions.containsKey(opcode) == false;
		instructions.put(opcode, i);

		if (name != null)
		{
			assert instructionsByName.containsKey(name) == false;
			instructionsByName.put(name, i);
		}
	}

<<<<<<< HEAD
=======
	protected void add(int opcode, int ipops, int ipushes)
	{
		add(opcode, null, ipops, ipushes, 0, 0);
	}

	protected void add(int opcode, int ipops, int ipushes, int spops, int spushes)
	{
		add(opcode, null, ipops, ipushes, spops, spushes);
	}

	protected void add(int opcode, String name, int ipops, int ipushes)
	{
		add(opcode, name, ipops, ipushes, 0, 0);
	}

>>>>>>> initial import of runelite
	public Instruction find(int opcode)
	{
		return instructions.get(opcode);
	}

	public Instruction find(String name)
	{
		return instructionsByName.get(name);
	}
}
