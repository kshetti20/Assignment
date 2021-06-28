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
                    "I am 22 years old, 5’6″ tall, with a medium build and a cheerful outlook towards life. I am a commerce graduate from Delhi University and I am currently figuring out the options I have in terms of pursuing my studies further or finding a job. I love painting and you will find some of my paintings adorning the walls of a few offices in Delhi! I use my paintings to shine a spotlight on the beauty of nature all around us. My parents tell me I am quite handy when it comes to taking up household chores. Actually, I enjoy decorating my home but I am also a stickler for cleanliness. I love spending time with my family and have a big circle of friends as well.";

                user = profile
                Glide.with(profileIV.context)
                    .load(profile.picture.large)
                    .into(profileIV)

                setAcceptanceView(profile.status)

                extFloatingActionButton.setOnClickListener {
                    profile.status = profile.status.xor(1)
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
            if (status == 0) {
                extFloatingActionButton.setText(CONNECT_NOW)
                extFloatingActionButton.setIconResource(R.drawable.approved)
            }
            else {
                extFloatingActionButton.setText(CONNECTED)
                extFloatingActionButton.setIconResource(R.drawable.ic_accept_tick)
            }
        }

    }


    companion object {
        const val CONNECTED = "Connected"
        const val CONNECT_NOW = "Connect Now"
    }


}