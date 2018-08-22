/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <https://unlicense.org>
 */

package com.bubelov.coins.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.util.Pair

import com.bubelov.coins.R
import com.bubelov.coins.ui.fragment.SignInFragment
import com.bubelov.coins.ui.fragment.SignUpFragment
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_email_sign_in.*

class EmailSignInActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_sign_in)
        pager.adapter = TabsAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(pager)
        toolbar.setNavigationOnClickListener { finish() }
    }

    private inner class TabsAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val pages = listOf<Pair<Fragment, String>>(
            Pair(SignInFragment(), getString(R.string.sign_in)),
            Pair(SignUpFragment(), getString(R.string.sign_up))
        )

        override fun getItem(position: Int): Fragment {
            return pages[position].first!!
        }

        override fun getPageTitle(position: Int): CharSequence {
            return pages[position].second!!
        }

        override fun getCount(): Int {
            return pages.size
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, EmailSignInActivity::class.java)
    }
}