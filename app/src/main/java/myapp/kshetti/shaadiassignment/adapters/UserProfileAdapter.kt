package myapp.kshetti.shaadiassignment.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.databinding.UserProfileRowBinding
import myapp.kshetti.trialapp.model.Results

class UserProfileAdapter(val results: List<Results>, val function: (Results) -> Unit) :
    RecyclerView.Adapter<UserProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserProfileRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(results[position])
    }

    override fun getItemCount() = results.size

    inner class ViewHolder(val binding: UserProfileRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(profile: Results) {
            binding.apply {
                setScrollingAnimation();

                aboutTV.text =
                    "'m 26 years outdated, 5’8″ tall, with a medium assemble and a constructive outlook within the course of life. I'm a Commerce Graduate from D.U. and at current figuring out totally different selections of pursuing my analysis further or discovering a job. According to my mom and father & mates, I'm a daring, self-made, down-to-earth specific particular person and I'm very energetic regarding taking up household duties. I like to decorate my residence with an entire stickler for hygiene. I'm searching for a Life Partner for me at  Milan Mantra using their beautiful biodata designs.";

                user = profile
                Glide.with(profileIV.context)
                    .load(profile.picture.large)
                    .into(profileIV)

                setAcceptanceView(profile.status)

                extFloatingActionButton.setOnClickListener {
                    profile.status = 1
                    function.invoke(profile)
                    setAcceptanceView(profile.status)
                }

                declineIV.setOnClickListener {
                    profile.status = -1
                    function.invoke(profile)
                    setAcceptanceView(profile.status)
                }
            }
        }

        private fun UserProfileRowBinding.setScrollingAnimation() {

            parentScrollView.setOnScrollChangeListener(object : View.OnScrollChangeListener {
                override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {

                    val diff: Int =
                        parentScrollView.getChildAt(
                            parentScrollView.getChildCount() - 1
                        ).bottom -
                                (parentScrollView.getHeight() +
                                        parentScrollView.getScrollY())

                    if (diff == 0) {
                        extFloatingActionButton.animate()
                            .translationY((extFloatingActionButton.marginBottom).toFloat())
                            .setInterpolator(LinearInterpolator()).setDuration(250).start()

                    } else {
                        extFloatingActionButton.animate().translationY(0F)
                            .setInterpolator(LinearInterpolator()).setDuration(250).start();
                    }
                }
            })
        }

        private fun UserProfileRowBinding.setAcceptanceView(status: Int) {

            if (status != 0) {
                declineIV.visibility = GONE
                acceptamceStatusTV.visibility = VISIBLE

                when (status) {
                    1 -> acceptamceStatusTV.text = "Accepted"
                    -1 -> acceptamceStatusTV.text = "Declined"
                }
            } else {
                declineIV.visibility = VISIBLE
                acceptamceStatusTV.visibility = GONE
            }
        }
    }

}